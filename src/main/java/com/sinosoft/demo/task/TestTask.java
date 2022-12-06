package com.sinosoft.demo.task;

import com.sinosoft.demo.util.CountryVaccinesUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

/**
 * @author hiYuzu
 * @version v1.0
 * @date 2022/11/30 20:21
 */
@Slf4j
@Component
public class TestTask {
    @Resource
    private CountryVaccinesUtil util;

    @PostConstruct
    public void test() {
    }
}
