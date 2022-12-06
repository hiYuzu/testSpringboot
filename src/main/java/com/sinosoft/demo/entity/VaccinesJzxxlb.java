package com.sinosoft.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author hiYuzu
 * @version v1.0
 * @date 2022/12/6 21:29
 */
@Data
@TableName("vaccines_jzxxlb")
public class VaccinesJzxxlb {
    @TableId
    private String id;
    private String basicId;
    private String ymmc;
    private String jc;
    private String jzrq;
    private String scqy;
    private String jzd;

}
