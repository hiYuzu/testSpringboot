package com.sinosoft.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 来冀返冀刷验数据
 *
 * @author hiYuzu
 * @version V1.0
 * @date 2022/8/7 22:29
 */

@Data
@TableName("contact_person")
public class ContactPerson {
    @TableId
    private String identity;
    private String zjlx;
    private String name;
    private Date exposeTime;
    private String type;
}
