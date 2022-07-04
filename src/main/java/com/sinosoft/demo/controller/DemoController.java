package com.sinosoft.demo.controller;

import cn.hutool.core.lang.UUID;
import cn.hutool.http.ContentType;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import com.sinosoft.demo.model.ResponseModel;
import com.sinosoft.demo.util.GlobalUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author hiYuzu
 * @version v1.0
 * @date 2022/6/21 15:36
 */
@Component
public class DemoController {
    private static final Logger LOG = LoggerFactory.getLogger(DemoController.class);

    @PostConstruct
    public void getCountryNucleic() {
        String token = "Bearer 28c70f4f06ba40a990b49fc2f90efadf";
        try {
            String encodeName1 = URLEncoder.encode("姓名", "UTF-8");
//            String url1 = "http://10.254.31.116:8280/hbwjw/result/getNcpNcovVaccinesInfo/v1.0.0?xm=" + encodeName1 + "&zjhm=证件号码";
            String url1 = "http://10.254.31.116:8280/hbwjw/result/getNcpNucleinInfo/v1.0.0?xm=" + encodeName1 + "&zjhm=证件号码";
            String responseBody1 = HttpUtil.createGet(url1).header("Authorization", token).contentType("application/json").execute().body();
            LOG.info("=================================================================");
            LOG.info(responseBody1);
            LOG.info("=================================================================");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void testGjDataChange() {
        String enveid = UUID.fastUUID().toString(true);
        String[] keywords = new String[]{"张三", "120111195203065431"};
        Map<String, String> encryptMap = getEncrypt(enveid, keywords);
        List<String> enKeyWords = new ArrayList<>();
        for (Map.Entry<String, String> entry : encryptMap.entrySet()) {
            System.out.println("====================================================");
            System.out.println(entry.getKey());
            System.out.println(entry.getValue());
            enKeyWords.add(entry.getValue());
            System.out.println("====================================================");
        }
        if (enKeyWords.size() > 0) {
            List<String> decrypted = getDecrypt(enveid, enKeyWords.toArray(new String[enKeyWords.size() - 1]));
            for (String content : decrypted) {
                System.out.println(content);
            }
        }
    }

    private Map<String, String> getEncrypt(String enveid, String[] keywords) {
        int initialCapacity = (int) Math.floor(keywords.length / 0.75) + 1;
        Map<String, String> encryptMap = new HashMap<>(initialCapacity);
        Map<String, Object> param = new HashMap<>(5);
        param.put("enveId", enveid);
        param.put("authCode", GlobalUtil.AUTH_CODE);
        param.put("keyword", keywords);
        String paramStr = JSONUtil.toJsonStr(param);
        System.out.println(paramStr);
        String responseBody = HttpUtil
                .createPost(GlobalUtil.ENCRYPT_URL)
                .contentType(ContentType.JSON.getValue())
                .body(paramStr)
                .execute()
                .body();
        System.out.println("responseBody:\n" + responseBody);
        ResponseModel responseModel = JSONUtil.toBean(responseBody, ResponseModel.class);
        if (responseModel != null) {
            List<ResponseModel.DataModel> dataModels = responseModel.getData();
            if (dataModels != null) {
                for (ResponseModel.DataModel dataModel : dataModels) {
                    encryptMap.put(dataModel.getKeyword(), dataModel.getEncryptStr());
                }
            }
        }
        return encryptMap;
    }

    private List<String> getDecrypt(String enveid, String[] keywords) {
        List<String> result = new ArrayList<>();
        Map<String, Object> param = new HashMap<>(5);
        param.put("enveId", enveid);
        param.put("authCode", GlobalUtil.AUTH_CODE);
        param.put("keyword", keywords);
        String paramStr = JSONUtil.toJsonStr(param);
        System.out.println(paramStr);
        String responseBody = HttpUtil
                .createPost(GlobalUtil.DECRYPT_URL)
                .contentType(ContentType.JSON.getValue())
                .body(paramStr)
                .execute()
                .body();
        System.out.println("responseBody:\n" + responseBody);
        ResponseModel responseModel = JSONUtil.toBean(responseBody, ResponseModel.class);
        if (responseModel != null) {
            List<ResponseModel.DataModel> dataModels = responseModel.getData();
            if (dataModels != null) {
                for (ResponseModel.DataModel dataModel : dataModels) {
                    result.add(dataModel.getDecryptStr());
                }
            }
        }
        return result;
    }
}
