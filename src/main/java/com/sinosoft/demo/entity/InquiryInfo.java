package com.sinosoft.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author hiYuzu
 * @version V1.0
 * @date 2022/11/12 13:39
 */
@TableName("inquiry_info")
@Data
public class InquiryInfo {
    private String contactCardNo;
    private String contactCardType;
    private String contactPersonName;
    private Date lastContactTime;
}
