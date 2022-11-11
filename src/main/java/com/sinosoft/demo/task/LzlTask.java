package com.sinosoft.demo.task;

import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.sinosoft.demo.entity.LzlTaskEntity;
import com.sinosoft.demo.service.ILzlTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author hiYuzu
 * @version V1.0
 * @date 2022/11/11 10:52
 */
@Slf4j
@Component
public class LzlTask {
    @Resource
    private ILzlTaskService lzlTaskService;

    @PostConstruct
    public void initData() {
        ExcelReader reader = ExcelUtil.getReader("F:/task.xlsx");
        List<LzlTaskEntity> entities = reader.readAll(LzlTaskEntity.class);
        log.info("读取数据量：" + entities.size());
        List<LzlTaskEntity> result = new ArrayList<>();
        for (LzlTaskEntity entity : entities) {
            LzlTaskEntity resultOne = new LzlTaskEntity();
            resultOne.setReportCardCode(entity.getReportCardCode().replaceAll("\"", "").replaceAll("\t", "").trim());
            result.add(resultOne);
        }
        log.info("转换数据量：" + result.size());
        lzlTaskService.saveBatch(result, 10000);
    }
}
