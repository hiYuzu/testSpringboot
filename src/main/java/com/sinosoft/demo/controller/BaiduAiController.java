package com.sinosoft.demo.controller;

import cn.hutool.core.io.FileUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 用于验证auth是否正确授权及应用程序是否正常运行
 *
 * @author hiYuzu
 * @version V1.0
 * @date 2022/5/16 15:22
 */
@RestController
@RequestMapping("/baiduai")
public class BaiduAiController {
    private static final String URL = "http://188.161.194.3:18000/baiduai/idcard/Ipa7JtwL/parseIdCard";
//    @PostConstruct
    @RequestMapping("/test")
    public void test() {
        File file = FileUtil.file("/opt/baiduai/test.jpg");
        Map<String, Object> fileMap = new HashMap<>(2);
        fileMap.put("file", file);

        try {
            HttpResponse response = HttpRequest.post(URL)
                    .header("IIG-AUTH", "jlf5ydoq-u7dh-olrp-n2mk-a8lrc8q3nfkw")
                    .form(fileMap)
                    .execute();
            System.out.println(response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
