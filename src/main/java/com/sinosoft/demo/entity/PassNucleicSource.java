package com.sinosoft.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author hiYuzu
 * @version V1.0
 * @date 2022/9/15 17:57
 */
@Data
@TableName("temp")
public class PassNucleicSource {
    private String name;
    private String identity;
}
