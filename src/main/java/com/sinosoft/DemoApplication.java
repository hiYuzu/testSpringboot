package com.sinosoft;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @author hiYuzu
 * @version V1.0
 * @date 2022/5/16 16:05
 */
@SpringBootApplication
@MapperScan(basePackages = {"com.sinosoft.demo.mapper"})
@EnableScheduling
@EnableAsync
public class DemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class);
    }
}
