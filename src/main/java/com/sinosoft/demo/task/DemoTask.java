package com.sinosoft.demo.task;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author hiYuzu
 * @version v1.0
 * @date 2022/8/11 12:06
 */
@Component
public class DemoTask {
    private static final Logger LOG = LoggerFactory.getLogger(DemoTask.class);

    public void test1() {
        LOG.info("test1");
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        LOG.info("test1, over");
    }

    public void test2() {
        LOG.info("test2");
        LOG.info("test2, over");
    }
}
