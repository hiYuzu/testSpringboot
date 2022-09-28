package com.sinosoft.demo.task;

import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author hiYuzu
 * @version V1.0
 * @date 2022/8/30 13:42
 */
@Slf4j
@Component
public class TestTask {
//    @PostConstruct
    public void test() {
        String identity = "130133195906283313";
        String url = "http://188.2.44.95:8090/openApi/getDetail?identity=" + identity;
        try (HttpResponse response = HttpUtil.createGet(url).header("IIG-AUTH", "jlf5ydoq-u7dh-olrp-n2mk-a8lrc8q3nfkw").setConnectionTimeout(20000).execute()) {
            String responseStr = response.body();
            JSONObject jsonObject = JSONUtil.parseObj(responseStr);
            if ("200".equals(jsonObject.getStr("code"))) {
                JSONObject data = jsonObject.getJSONObject("data");
                System.out.println(JSONUtil.toJsonPrettyStr(data));
            }
        }
    }
}
