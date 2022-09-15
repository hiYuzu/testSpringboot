package com.sinosoft.demo.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sinosoft.demo.entity.PassNucleicResult;
import com.sinosoft.demo.mapper.PassNucleicResultMapper;
import com.sinosoft.demo.service.IPassNucleicResultService;
import org.springframework.stereotype.Service;

/**
 * @author hiYuzu
 * @version V1.0
 * @date 2022/9/15 18:16
 */
@Service("passNucleicResultService")
@DS("temp")
public class PassNucleicResultServiceImpl extends ServiceImpl<PassNucleicResultMapper, PassNucleicResult> implements IPassNucleicResultService {
}
