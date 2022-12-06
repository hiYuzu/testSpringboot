package com.sinosoft.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author hiYuzu
 * @version V1.0
 * @date 2022/12/6 20:30
 */
@Data
@TableName("country_vaccines")
public class CountryVaccines {
    @TableId
    private String idCard;
    /**
     * 风险人员证件号码
     */
    private String name;
}
