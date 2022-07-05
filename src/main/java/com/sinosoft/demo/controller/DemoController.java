package com.sinosoft.demo.controller;

import cn.hutool.http.HttpUtil;
import com.sinosoft.demo.util.GlobalUtil;
import org.springframework.web.bind.annotation.*;

import java.net.URLEncoder;

/**
 * @author hiYuzu
 * @version v1.0
 * @date 2022/6/21 15:36
 */
@RestController
@RequestMapping("/openApi/demo/")
public class DemoController {
    @GetMapping("/getCountryNucleic")
    public String getCountryNucleic(@RequestHeader(name = GlobalUtil.AUTH_HEADER) String authHeader , @RequestParam(name = "name") String name, @RequestParam(name = "idCard") String idCard) {
        if (!GlobalUtil.IIG_AUTH.equals(authHeader)) {
            return "未授权的访问！";
        }
        try {
            String url1 = "http://10.254.31.116:8280/hbwjw/result/getNcpNucleinInfo/v1.0.0?xm=" + URLEncoder.encode(name, "UTF-8") + "&zjhm=" + idCard;
            return HttpUtil.createGet(url1).header("Authorization", GlobalUtil.BEARER_TOKEN).contentType("application/json").execute().body();
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
