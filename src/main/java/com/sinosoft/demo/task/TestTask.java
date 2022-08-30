package com.sinosoft.demo.task;

import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sinosoft.demo.entity.HbjkmZdgkryAuto;
import com.sinosoft.demo.service.IHbjkmZdgkryAutoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author hiYuzu
 * @version V1.0
 * @date 2022/8/30 13:42
 */
@Component
public class TestTask {
    private static final Logger LOG = LoggerFactory.getLogger(TestTask.class);

    @Resource
    private IHbjkmZdgkryAutoService hbjkmZdgkryAutoService;

    @PostConstruct
    public void test() {
        LOG.info("测试数据库连接...");
        QueryWrapper<HbjkmZdgkryAuto> queryWrapper = new QueryWrapper<>();
        queryWrapper.gt("create_time", "2022-08-30 13:00:00").last("LIMIT 1");
        System.out.println(JSONUtil.toJsonPrettyStr(hbjkmZdgkryAutoService.list(queryWrapper).get(0)));
    }
}
