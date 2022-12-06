package com.sinosoft.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author hiYuzu
 * @version v1.0
 * @date 2022/12/6 21:28
 */
@Data
@TableName("vaccines_basic")
public class VaccinesBasic {
    @TableId
    private String id;
    private String gj;
    private String gazt;
    private String xm;
    private String zjlx;
    private String grdabh;
    private String zjhm;
}
