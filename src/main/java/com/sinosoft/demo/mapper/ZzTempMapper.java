package com.sinosoft.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sinosoft.demo.entity.ZzTemp;
import org.apache.ibatis.annotations.Param;

/**
 * @author hiYuzu
 * @version v1.0
 * @date 2022/9/3 0:01
 */
public interface ZzTempMapper extends BaseMapper<ZzTemp> {
    void updateSourceData(@Param("tableName") String tableName, @Param("pxhsjhm") String pxhsjhm);
}
