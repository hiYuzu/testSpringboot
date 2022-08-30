package com.sinosoft.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.sinosoft.demo.entity.SysLoginLog;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

/**
 * @author hiYuzu
 * @version V1.0
 * @date 2022/7/27 16:37
 */
public interface SysLoginLogMapper extends BaseMapper<SysLoginLog> {
    /**
     * 测试按日期删除
     *
     * @param today 今天的日期
     */
    void deleteFrom(@Param("today")Date today);
}
