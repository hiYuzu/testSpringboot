package com.sinosoft.demo.pojo;

import lombok.Data;

import java.util.List;

/**
 * @author hiYuzu
 * @version v1.0
 * @date 2022/12/6 20:48
 */
@Data
public class VaccinesResult {
    private String gj;
    private String gazt;
    private String xm;
    private String zjlx;
    private String grdabh;
    private String zjhm;
    private List<Jzxxlb> jzxxlb;
    @Data
    public static class Jzxxlb {
        private String ymmc;
        private String jc;
        private String jzrq;
        private String scqy;
        private String jzd;
    }
}
