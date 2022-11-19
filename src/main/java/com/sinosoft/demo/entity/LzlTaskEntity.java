package com.sinosoft.demo.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author hiYuzu
 * @version V1.0
 * @date 2022/11/11 10:51
 */
@TableName("lzl_task")
@Data
public class LzlTaskEntity {
    @TableId
    private String reportCardCode;
}
