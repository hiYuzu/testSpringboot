package com.sinosoft.demo.service;


import com.baidu.aip.ocr.AipOcr;
import com.sinosoft.demo.entity.IdCardInfoEntity;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @author hiYuzu
 * @version V1.0
 * @date 2022/5/16 17:46
 */


@Service
public class BaiduAiService {
    @Value("${baidu.appId}")
    public String appId;
    @Value("${baidu.apiKey}")
    public String apiKey;
    @Value("${baidu.secretKey}")
    public String secretKey;
    @Resource
    private AipOcr aipOcr;

    public IdCardInfoEntity getIdCardInfoEntity(byte[] data) throws RuntimeException {
        // 调用接口
        JSONObject jsonObject = aipOcr.idcard(data, "front", null);
        String imageStatus = jsonObject.getString("image_status");
        switch (imageStatus) {
            case "normal": {
                //识别正常
                IdCardInfoEntity idCardInfoEntity = new IdCardInfoEntity();
                JSONObject wordsResult = jsonObject.getJSONObject("words_result");
                String name = wordsResult.getJSONObject("姓名").getString("words");
                idCardInfoEntity.setName(name);
                String address = wordsResult.getJSONObject("住址").getString("words");
                idCardInfoEntity.setAddress(address);
                String idNumber = wordsResult.getJSONObject("公民身份号码").getString("words");
                idCardInfoEntity.setIdNumber(idNumber);
                String birthday = wordsResult.getJSONObject("出生").getString("words");
                idCardInfoEntity.setBirthday(birthday);
                String sex = wordsResult.getJSONObject("性别").getString("words");
                idCardInfoEntity.setSex(sex);
                String nation = wordsResult.getJSONObject("民族").getString("words");
                idCardInfoEntity.setNation(nation);
                return idCardInfoEntity;
            }
            case "reversed_side": {
                throw new RuntimeException("未摆正身份证");
            }
            case "non_idcard": {
                throw new RuntimeException("上传的图片中不包含身份证");

            }
            case "blurred": {
                throw new RuntimeException("身份证模糊");

            }
            case "over_exposure": {
                throw new RuntimeException("身份证关键字段反光或过曝");
            }
            default:
                throw new RuntimeException("未知错误");
        }
    }
}


