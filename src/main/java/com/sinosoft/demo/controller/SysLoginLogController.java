package com.sinosoft.demo.controller;

import com.sinosoft.demo.service.ISysLoginLogService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author hiYuzu
 * @version V1.0
 * @date 2022/7/27 16:40
 */
@RequestMapping("/demo/sysLoginLog")
@RestController
public class SysLoginLogController {
    @Resource
    private ISysLoginLogService sysLoginLogService;
}
