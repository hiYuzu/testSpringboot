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
     * 风险人员证件号码
     */
    private String fxryzjhm;
    /**
     * 风险人员证件类型
     */
    private String fxryzjlx;
    /**
     * 风险人员姓名
     */
    private String fxryxm;
    /**
     * 最后暴露日期
     */
    private Date zhblrq;
    /**
     * 风险人员类别
     */
    private String fxrylb;

    // --- 以下是详情所需要的字段 --- //
    /**
     * 协查工单序号（仅工单）
     */
    private String xcgdxh;
    /**
     * 风险人员来源县区（仅工单）
     */
    private String fxryxq;
    /**
     * 协查提出机构名称（仅工单）
     */
    private String xctcjgmc;
    /**
     * 风险人员手机号（工单+流调）
     */
    private String fxryjh;
    /**
     * 风险人员详细地址/接触地址（工单+流调）
     */
    private String fxryxxdz;
    /**
     * 暴露方式/接触方式（工单+流调）
     */
    private String jcfs;
    /**
     * 流调-城市
     */
    private String city;
    /**
     * 流调-区县
     */
    private String county;
    /**
     * 数据推送省份（仅工单）
     */
    private String sjtssf;
    /**
     * 数据推送时间（仅工单）
     */
    private Date sjtssj;

    /**
     * 导入日期（仅导入）
     */
    private Date importTime;
    /**
     * 导入备注（仅导入）
     */
    private String importRemark;
}
