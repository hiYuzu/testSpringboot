package com.sinosoft.demo.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author hiYuzu
 * @version V1.0
 * @date 2022/5/16 17:46
 */
public class GlobalUtil {
    public static final String AUTH_HEADER = "IIG-AUTH";
    public static final String IIG_AUTH = "jlf5ydoq-u7dh-olrp-n2mk-a8lrc8q3nfkw";

    public static final String BEARER_TOKEN = "Bearer 28c70f4f06ba40a990b49fc2f90efadf";

    public static final Map<String, String> ZJLX_MAP = new HashMap<>();

    static {
        ZJLX_MAP.put("111", "0");
        ZJLX_MAP.put("身份证", "0");
        ZJLX_MAP.put("400", "1");
        ZJLX_MAP.put("护照", "1");
        ZJLX_MAP.put("港澳通行证", "11");
        ZJLX_MAP.put("台湾通行证", "12");
    }
}
