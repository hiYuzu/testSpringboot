package com.sinosoft.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @author hiYuzu
 * @version V1.0
 * @date 2022/7/27 16:35
 */
@Data
@TableName("sys_login_log")
public class SysLoginLog {
    @TableId
    private Integer ulId;
    private Integer userId;
    private String loginIp;
    private String ipPlace;
    private Date loginTime;
    private Integer success;
    private String failReason;
}
