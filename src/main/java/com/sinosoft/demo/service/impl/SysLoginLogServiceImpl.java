package com.sinosoft.demo.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sinosoft.demo.entity.SysLoginLog;
import com.sinosoft.demo.mapper.SysLoginLogMapper;
import com.sinosoft.demo.service.ISysLoginLogService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Calendar;
import java.util.Date;

/**
 * @author hiYuzu
 * @version V1.0
 * @date 2022/7/27 16:38
 */
@Service("sysLoginLogService")
public class SysLoginLogServiceImpl extends ServiceImpl<SysLoginLogMapper, SysLoginLog> implements ISysLoginLogService {
    @PostConstruct
    public void test() {
        System.out.println("测试开始...");
        Date today = DateUtil.parse("2010-09-13 00:00:00");
        baseMapper.deleteFrom(today);
    }
}
