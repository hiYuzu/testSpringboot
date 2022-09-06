package com.sinosoft.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author hiYuzu
 * @version V1.0
 * @date 2022/8/7 22:29
 */
@Data
@TableName("datav_buy_medicine_info")
public class MedicineAlInfo {
    private String purchaserCardNo;
    private String region;
}
