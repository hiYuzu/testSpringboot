package com.sinosoft.demo.task;

import cn.hutool.json.JSONUtil;
import com.sinosoft.demo.entity.ZzTemp;
import com.sinosoft.demo.service.IZzTempService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hiYuzu
 * @version v1.0
 * @date 2022/9/2 23:59
 */
@Slf4j
@Component
public class RiskTask {
    @Resource
    private IZzTempService zzTempService;

    @PostConstruct
    public void update() {
        log.info("开始处理...");
        List<ZzTemp> zzTemps = zzTempService.list();
        log.info("数据量：" + zzTemps.size());
        List<ZzTemp> zzTemps130100 = zzTemps.stream().filter((one) -> "tbl_dsjts_finish_130100".equals(one.getTableName())).collect(Collectors.toList());
        List<ZzTemp> zzTemps130200 = zzTemps.stream().filter((one) -> "tbl_dsjts_finish_130200".equals(one.getTableName())).collect(Collectors.toList());
        List<ZzTemp> zzTemps130300 = zzTemps.stream().filter((one) -> "tbl_dsjts_finish_130300".equals(one.getTableName())).collect(Collectors.toList());
        List<ZzTemp> zzTemps130400 = zzTemps.stream().filter((one) -> "tbl_dsjts_finish_130400".equals(one.getTableName())).collect(Collectors.toList());
        List<ZzTemp> zzTemps130500 = zzTemps.stream().filter((one) -> "tbl_dsjts_finish_130500".equals(one.getTableName())).collect(Collectors.toList());
        List<ZzTemp> zzTemps130600 = zzTemps.stream().filter((one) -> "tbl_dsjts_finish_130600".equals(one.getTableName())).collect(Collectors.toList());
        List<ZzTemp> zzTemps130700 = zzTemps.stream().filter((one) -> "tbl_dsjts_finish_130700".equals(one.getTableName())).collect(Collectors.toList());
        List<ZzTemp> zzTemps130800 = zzTemps.stream().filter((one) -> "tbl_dsjts_finish_130800".equals(one.getTableName())).collect(Collectors.toList());
        List<ZzTemp> zzTemps130900 = zzTemps.stream().filter((one) -> "tbl_dsjts_finish_130900".equals(one.getTableName())).collect(Collectors.toList());
        List<ZzTemp> zzTemps131000 = zzTemps.stream().filter((one) -> "tbl_dsjts_finish_131000".equals(one.getTableName())).collect(Collectors.toList());
        List<ZzTemp> zzTemps131100 = zzTemps.stream().filter((one) -> "tbl_dsjts_finish_131100".equals(one.getTableName())).collect(Collectors.toList());
        List<ZzTemp> zzTemps133100 = zzTemps.stream().filter((one) -> "tbl_dsjts_finish_133100".equals(one.getTableName())).collect(Collectors.toList());
        List<ZzTemp> zzTemps139800 = zzTemps.stream().filter((one) -> "tbl_dsjts_finish_139800".equals(one.getTableName())).collect(Collectors.toList());
        List<ZzTemp> zzTemps139900 = zzTemps.stream().filter((one) -> "tbl_dsjts_finish_139900".equals(one.getTableName())).collect(Collectors.toList());
        zzTempService.updateSourceData("tbl_dsjts_finish_130100", zzTemps130100);
        zzTempService.updateSourceData("tbl_dsjts_finish_130200", zzTemps130200);
        zzTempService.updateSourceData("tbl_dsjts_finish_130300", zzTemps130300);
        zzTempService.updateSourceData("tbl_dsjts_finish_130400", zzTemps130400);
        zzTempService.updateSourceData("tbl_dsjts_finish_130500", zzTemps130500);
        zzTempService.updateSourceData("tbl_dsjts_finish_130600", zzTemps130600);
        zzTempService.updateSourceData("tbl_dsjts_finish_130700", zzTemps130700);
        zzTempService.updateSourceData("tbl_dsjts_finish_130800", zzTemps130800);
        zzTempService.updateSourceData("tbl_dsjts_finish_130900", zzTemps130900);
        zzTempService.updateSourceData("tbl_dsjts_finish_131000", zzTemps131000);
        zzTempService.updateSourceData("tbl_dsjts_finish_131100", zzTemps131100);
        zzTempService.updateSourceData("tbl_dsjts_finish_133100", zzTemps133100);
        zzTempService.updateSourceData("tbl_dsjts_finish_139800", zzTemps139800);
        zzTempService.updateSourceData("tbl_dsjts_finish_139900", zzTemps139900);
        log.info("处理完毕。");
    }
}
