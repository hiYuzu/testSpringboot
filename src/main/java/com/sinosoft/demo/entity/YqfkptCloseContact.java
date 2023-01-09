package com.sinosoft.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author hiYuzu
 * @version V1.0
 * @date 2022/9/13 14:30
 */
@Data
@TableName("yqfkpt_close_contact_20221007_tc")
public class YqfkptCloseContact {
    @TableId
    private String id;
    /**
     * 最后暴露日期
     */
    private Date zhblrq;
}
