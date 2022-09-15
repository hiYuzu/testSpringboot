package com.sinosoft.demo.task;

import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.sinosoft.demo.entity.PassNucleicResult;
import com.sinosoft.demo.entity.PassNucleicSource;
import com.sinosoft.demo.service.IPassNucleicResultService;
import com.sinosoft.demo.service.IPassNucleicSourceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hiYuzu
 * @version V1.0
 * @date 2022/9/15 17:57
 */
@Slf4j
@Component
public class PassNucleicTask {
    @Resource
    private IPassNucleicSourceService passNucleicSourceService;
    @Resource
    private IPassNucleicResultService passNucleicResultService;

//    @PostConstruct
    public void matchData() {
        List<PassNucleicSource> list = passNucleicSourceService.list();
        List<PassNucleicResult> resultList = new ArrayList<>();
        log.info("待匹配数量：" + list.size());
        for (PassNucleicSource entity : list) {
            PassNucleicResult result = getNucleicFromCountry(entity.getName(), entity.getIdentity());
            if (result != null) {
                resultList.add(result);
            }
        }
        int resultSize = resultList.size();
        log.info("待保存数量：" + resultSize);
        if (resultSize > 0) {
            passNucleicResultService.saveBatch(resultList);
        }
    }

    private PassNucleicResult getNucleicFromCountry(String name, String identity) {
        try {
            String encodeName = URLEncoder.encode(name, "UTF-8");
            String url = "http://10.254.31.116:8280/hbwjw/result/getNcpNucleinInfo/v1.0.0?xm=" + encodeName + "&zjhm=" + identity;
            try (HttpResponse response = HttpUtil.createGet(url).header("Authorization", "Bearer 28c70f4f06ba40a990b49fc2f90efadf").execute()) {
                String responseStr = response.body();
                JSONObject jsonObject = JSONUtil.parseObj(responseStr);
                if ("200".equals(jsonObject.getStr("code")) && StrUtil.isNotBlank(jsonObject.getStr("data"))) {
                    JSONObject data = jsonObject.getJSONObject("data");
                    PassNucleicResult result = new PassNucleicResult();
                    result.setHsjcsj(data.getStr("hsjcsj"));
                    result.setHsjcjg(data.getStr("hsjcjg"));
                    result.setHsjcjgmc(data.getStr("hsjcjgmc"));
                    result.setName(name);
                    result.setIdentity(identity);
                    return result;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
