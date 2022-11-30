package com.sinosoft.demo.task;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sinosoft.demo.entity.YqfkptCloseContact;
import com.sinosoft.demo.service.IYqfkptCloseContactService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author hiYuzu
 * @version v1.0
 * @date 2022/11/30 20:21
 */
@Slf4j
@Component
public class TestTask {
    @Resource
    private IYqfkptCloseContactService yqfkptCloseContactService;

    @PostConstruct
    public void test() {
        String identity = "520221200206061812";
        String startDate = "2022-11-21";
        String fxrylb = "01";

        QueryWrapper<YqfkptCloseContact> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("fxryzjhm", "fxryzjlx", "fxryxm", "zhblrq", "fxrylb", "xcgdxh", "fxryxq", "xctcjgmc", "fxryjh", "fxryxxdz", "jcfs", "sjtssf", "sjtssj");
        queryWrapper.eq("fxryzjhm", identity);
        queryWrapper.eq("SUBSTR(zhblrq, 1, 10)", startDate);
        queryWrapper.eq("fxrylb", fxrylb);
        queryWrapper.last("LIMIT 1");
        List<YqfkptCloseContact> results = yqfkptCloseContactService.list(queryWrapper);
        if (results.size() > 0) {
            String result = JSONUtil.toJsonPrettyStr(results.get(0));
            log.info("list：");
            log.info(result);
        }
        YqfkptCloseContact result = yqfkptCloseContactService.getOne(queryWrapper);
        String one = JSONUtil.toJsonPrettyStr(results.get(0));
        log.info("getOne：");
        log.info(one);

        QueryWrapper<YqfkptCloseContact> queryWrapperId = new QueryWrapper<>();
        queryWrapperId.select("id");
        queryWrapperId.eq("fxryzjhm", identity);
        queryWrapperId.eq("SUBSTR(zhblrq, 1, 10)", startDate);
        queryWrapperId.eq("fxrylb", fxrylb);
        queryWrapperId.last("LIMIT 1");
        Map<String, Object> resultMap = yqfkptCloseContactService.getMap(queryWrapperId);
        if (resultMap != null) {
            String id = resultMap.get("id").toString();
            log.info("map-id：" + id);
            YqfkptCloseContact yqfkptCloseContact = yqfkptCloseContactService.getById(id);
            String getById = JSONUtil.toJsonPrettyStr(results.get(0));
            log.info("getById：");
            log.info(getById);
        }
    }
}
