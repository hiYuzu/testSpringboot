package com.sinosoft.demo.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sinosoft.demo.entity.MedicineAlInfo;
import com.sinosoft.demo.mapper.MedicineInfoAlMapper;
import com.sinosoft.demo.service.IMedicineInfoAlService;
import org.springframework.stereotype.Service;

/**
 * @author hiYuzu
 * @version V1.0
 * @date 2022/8/7 22:30
 */
@Service("medicineInfoAlService")
@DS("drugs")
public class MedicineInfoAlServiceImpl extends ServiceImpl<MedicineInfoAlMapper, MedicineAlInfo> implements IMedicineInfoAlService {
}
