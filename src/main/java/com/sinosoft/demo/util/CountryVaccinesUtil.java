package com.sinosoft.demo.util;

import cn.hutool.core.lang.UUID;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sinosoft.demo.entity.CountryVaccines;
import com.sinosoft.demo.entity.VaccinesBasic;
import com.sinosoft.demo.entity.VaccinesJzxxlb;
import com.sinosoft.demo.pojo.CountryNucleic;
import com.sinosoft.demo.pojo.VaccinesResult;
import com.sinosoft.demo.service.ICountryVaccinesService;
import com.sinosoft.demo.service.IVaccinesBasicService;
import com.sinosoft.demo.service.IVaccinesJzxxlbService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hiYuzu
 * @version v1.0
 * @date 2022/12/6 20:55
 */
@Slf4j
@Component
public class CountryVaccinesUtil {
    @Resource
    private ICountryVaccinesService countryVaccinesService;
    @Resource
    private IVaccinesBasicService vaccinesBasicService;
    @Resource
    private IVaccinesJzxxlbService vaccinesJzxxlbService;

    public void getData() {
        List<CountryVaccines> list = countryVaccinesService.list();
        log.info("数据量：" + list.size());
        int i = 0;
        List<VaccinesResult> results = new ArrayList<>();
        for (CountryVaccines entity : list) {
            i++;
            if (i % 10000 == 0) {
                log.info("查询了" + i + "条数据...");
            }
            String name = entity.getName();
            String idCard = entity.getIdCard();
            String url = "http://188.2.44.39/openApi/getCountryVaccines?name=" + name + "&idCard=" + idCard;
            try (HttpResponse response = HttpUtil.createGet(url).header("IIG-AUTH", "jlf5ydoq-u7dh-olrp-n2mk-a8lrc8q3nfkw").execute()) {
                String body = response.body();
                body = body.replaceAll("\\\\", "").replaceAll("\"", "");
                JSONObject jsonObject;
                try {
                    jsonObject = JSONUtil.parseObj(body);
                } catch (Exception e) {
                    VaccinesResult temp = new VaccinesResult();
                    temp.setXm(name);
                    temp.setZjhm(idCard);
                    temp.setGrdabh("没有查询到信息");
                    results.add(temp);
                    continue;
                }
                String data = jsonObject.getStr("data");
                if (StrUtil.isNotBlank(data)) {
                    JSONObject jsonObject1 = JSONUtil.parseObj(data);
                    VaccinesResult temp = JSONUtil.toBean(jsonObject1, VaccinesResult.class);
                    results.add(temp);
                } else {
                    VaccinesResult temp = new VaccinesResult();
                    temp.setXm(name);
                    temp.setZjhm(idCard);
                    temp.setGrdabh("没有查询到信息");
                    results.add(temp);
                }
            }
        }
        log.info("数据查询完毕，开始转换入库...");
        convertAndSaveResult(results);
    }

    private void convertAndSaveResult(List<VaccinesResult> results) {
        List<VaccinesBasic> basics = new ArrayList<>();
        List<VaccinesJzxxlb> jzxxlbs = new ArrayList<>();
        for (VaccinesResult result : results) {
            VaccinesBasic basic = new VaccinesBasic();
            String basicId = UUID.fastUUID().toString(true);
            basic.setId(basicId);
            basic.setXm(result.getXm());
            basic.setZjhm(result.getZjhm());
            basic.setZjlx(result.getZjlx());
            basic.setGj(result.getGj());
            basic.setGazt(result.getGazt());
            basic.setGrdabh(result.getGrdabh());
            basics.add(basic);
            if (result.getJzxxlb() != null) {
                for (VaccinesResult.Jzxxlb resultJzxxlb : result.getJzxxlb()) {
                    VaccinesJzxxlb jzxxlb = new VaccinesJzxxlb();
                    String jzxxlbId = UUID.fastUUID().toString(true);
                    jzxxlb.setId(jzxxlbId);
                    jzxxlb.setBasicId(basicId);
                    jzxxlb.setScqy(resultJzxxlb.getScqy());
                    jzxxlb.setJzrq(resultJzxxlb.getJzrq());
                    jzxxlb.setJc(resultJzxxlb.getJc());
                    jzxxlb.setJzd(resultJzxxlb.getJzd());
                    jzxxlb.setYmmc(resultJzxxlb.getYmmc());
                    jzxxlbs.add(jzxxlb);
                }
            }
        }
        vaccinesBasicService.saveBatch(basics, 5000);
        vaccinesJzxxlbService.saveBatch(jzxxlbs, 10000);
    }
}
