package com.sinosoft.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sinosoft.demo.entity.PassNucleicSource;
import com.sinosoft.demo.mapper.PassNucleicSourceMapper;
import com.sinosoft.demo.service.IPassNucleicSourceService;
import org.springframework.stereotype.Service;

/**
 * @author hiYuzu
 * @version V1.0
 * @date 2022/9/15 18:01
 */
@Service("passNucleicSourceService")
public class PassNucleicSourceServiceImpl extends ServiceImpl<PassNucleicSourceMapper, PassNucleicSource> implements IPassNucleicSourceService {
}
