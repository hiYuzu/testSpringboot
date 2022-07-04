package com.sinosoft.demo.model;

import lombok.Data;

import java.util.List;

/**
 * @author hiYuzu
 * @version v1.0
 * @date 2022/6/21 9:50
 */
@Data
public class ResponseModel {
    private Boolean success;
    private Integer status;
    private String message;
    private List<DataModel> data;

    @Data
    public static class DataModel {
        private String encryptStr;
        private String decryptStr;
        private String keyword;
        private String enveId;
        private Boolean success;
    }
}
