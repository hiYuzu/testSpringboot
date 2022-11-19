package com.sinosoft.demo.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sinosoft.demo.entity.InquiryInfo;
import com.sinosoft.demo.mapper.InquiryInfoMapper;
import com.sinosoft.demo.service.IInquiryInfoService;
import org.springframework.stereotype.Service;

/**
 * @author hiYuzu
 * @version V1.0
 * @date 2022/11/12 13:44
 */
@Service("inquiryInfoService")
@DS("query")
public class InquiryInfoServiceImpl extends ServiceImpl<InquiryInfoMapper, InquiryInfo> implements IInquiryInfoService {
}
