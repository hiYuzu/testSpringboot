package com.sinosoft.demo.task;

import lombok.extern.slf4j.Slf4j;
import org.jasypt.encryption.StringEncryptor;
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
    private StringEncryptor encryptor;

    @PostConstruct
    public void test() {
        String text = "root";
        String encryptText = encryptor.encrypt(text);
        System.out.println(encryptText);
    }
}
