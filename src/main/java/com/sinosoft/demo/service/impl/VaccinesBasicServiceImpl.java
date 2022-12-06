package com.sinosoft.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sinosoft.demo.entity.VaccinesBasic;
import com.sinosoft.demo.mapper.VaccinesBasicMapper;
import com.sinosoft.demo.service.IVaccinesBasicService;
import org.springframework.stereotype.Service;

/**
 * @author hiYuzu
 * @version v1.0
 * @date 2022/12/6 21:32
 */
@Service("vaccinesBasicService")
public class VaccinesBasicServiceImpl extends ServiceImpl<VaccinesBasicMapper, VaccinesBasic> implements IVaccinesBasicService {
}
