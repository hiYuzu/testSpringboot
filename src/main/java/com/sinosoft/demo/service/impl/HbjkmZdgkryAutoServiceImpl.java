package com.sinosoft.demo.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sinosoft.demo.entity.HbjkmZdgkryAuto;
import com.sinosoft.demo.mapper.HbjkmZdgkryAutoMapper;
import com.sinosoft.demo.service.IHbjkmZdgkryAutoService;
import org.springframework.stereotype.Service;

/**
 * @author hiYuzu
 * @version v1.0
 * @date 2022/8/17 18:00
 */
@Service("hbjkmZdgkryAutoService")
@DS("jkm")
public class HbjkmZdgkryAutoServiceImpl extends ServiceImpl<HbjkmZdgkryAutoMapper, HbjkmZdgkryAuto> implements IHbjkmZdgkryAutoService {
}
