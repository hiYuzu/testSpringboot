package com.sinosoft.demo.task;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * @author hiYuzu
 * @version V1.0
 * @date 2022/10/8 14:43
 */
@Component
public class AloneTask {
//    @PostConstruct
    public void test() {
        // IP地址
        String ip = "188.2.44.72";
        // 端口
        String port = "8082";
        // 授权码
        String auth = "jlf5ydoq-u7dh-olrp-n2mk-a8lrc8q3nfkw";
        // 查询类型
        String codeType = "popcode";
        // 证件号码
        String identity = "1231231231232133";
        // 开始日期
        String startDate = "2022-09-29";
        // 分类
        String fl = "60";

        HttpURLConnection con1;
        HttpURLConnection con2;
        BufferedReader buffer;
        StringBuilder resultBuilder;
        try {
            URL url = new URL("http://"+ ip + ":" + port + "/history/openApi/appeal/getPersonInfo?identity=" + identity + "&codeType=" + codeType);
            URL url2 = new URL("http://"+ ip + ":" + port + "/history/openApi/appeal/getDataDetail?identity=" + identity + "&fl=" + fl + "&startDate=" + startDate);
            con1 = (HttpURLConnection) url.openConnection();
            con2 = (HttpURLConnection) url2.openConnection();
            con1.setRequestMethod("GET");
            con2.setRequestMethod("GET");
            con1.setRequestProperty("IIG-AUTH", auth);
            con2.setRequestProperty("IIG-AUTH", auth);
            con1.setDoOutput(true);
            con2.setDoOutput(true);
            con1.setUseCaches(false);
            con2.setUseCaches(false);
            if (con1.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = con1.getInputStream();
                resultBuilder = new StringBuilder();
                String line;
                buffer = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
                while ((line = buffer.readLine()) != null) {
                    resultBuilder.append(line);
                }
                System.out.println(resultBuilder);
            }
            if (con2.getResponseCode() == HttpURLConnection.HTTP_OK) {
                InputStream inputStream = con2.getInputStream();
                resultBuilder = new StringBuilder();
                String line;
                buffer = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
                while ((line = buffer.readLine()) != null) {
                    resultBuilder.append(line);
                }
                System.out.println(resultBuilder);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
