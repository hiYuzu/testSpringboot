package com.sinosoft.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author hiYuzu
 * @version v1.0
 * @date 2022/8/17 17:58
 */
@Data
@TableName("hbjkm_zdgkry_auto")
public class HbjkmZdgkryAuto {
    private String identity;
    private String fxdj;
    private String fl;
    private String startDate;
    private Date createTime;
}
