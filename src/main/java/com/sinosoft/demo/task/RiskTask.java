package com.sinosoft.demo.task;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sinosoft.demo.entity.ZzTemp;
import com.sinosoft.demo.service.IZzTempService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;

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
        int count = 0;
        for (ZzTemp temp : zzTemps) {
            count++;
            try {
                zzTempService.updateSourceData(temp.getTableName(), temp.getFxrysjh());
            } catch (Exception e) {
                e.printStackTrace();
                log.error(JSONUtil.toJsonPrettyStr(temp));
            }
            if (count % 1000 == 0) {
                log.info("已处理数量：" + count);
            }
        }
        log.info("处理完毕。");
    }
}
