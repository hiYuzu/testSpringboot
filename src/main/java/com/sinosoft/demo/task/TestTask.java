package com.sinosoft.demo.task;

import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sinosoft.demo.entity.MedicineAlInfo;
import com.sinosoft.demo.entity.MedicineInfoTemp;
import com.sinosoft.demo.service.IMedicineInfoAlService;
import com.sinosoft.demo.service.IMedicineInfoTempService;
import com.sinosoft.demo.util.GlobalUtil;
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
 * @date 2022/8/30 13:42
 */
@Slf4j
@Component
public class TestTask {

    @Resource
    private IMedicineInfoAlService medicineInfoAlService;
    @Resource
    private IMedicineInfoTempService medicineInfoTempService;

//    @PostConstruct
    public void test() {
        log.info("测试数据库连接...");
        QueryWrapper<MedicineAlInfo> alQw = new QueryWrapper<>();
        alQw.ge("buy_time", "2022-08-30 00:00:00").lt("buy_time", "2022-09-03 00:00:00");
        alQw.select("UPPER(purchaser_card_no) AS purchaser_card_no", "SUBSTRING(region FROM 1 FOR 4) AS region");
        List<MedicineAlInfo> alInfos = medicineInfoAlService.list(alQw);
        log.info("数据量：" + alInfos.size());
        List<MedicineInfoTemp> tempList = convertList(alInfos);
        medicineInfoTempService.saveBatch(tempList, 100000);
    }

    private List<MedicineInfoTemp> convertList(List<MedicineAlInfo> alInfos) {
        List<MedicineInfoTemp> tempList = new ArrayList<>();
        for (MedicineAlInfo alInfo : alInfos) {
            MedicineInfoTemp temp = new MedicineInfoTemp();
            temp.setPurchaserCardNo(alInfo.getPurchaserCardNo());
            temp.setRegion(alInfo.getRegion());
            tempList.add(temp);
        }
        return tempList;
    }
}
