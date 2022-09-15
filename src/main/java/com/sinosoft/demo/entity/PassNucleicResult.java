package com.sinosoft.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author hiYuzu
 * @version V1.0
 * @date 2022/9/15 18:12
 */
@Data
@TableName("temp_result")
public class PassNucleicResult {
    private String name;
    private String identity;
    private String hsjcsj;
    private String hsjcjg;
    private String hsjcjgmc;
}
