package com.sinosoft.demo.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sinosoft.demo.entity.MedicineInfoTemp;
import com.sinosoft.demo.mapper.MedicineInfoTempMapper;
import com.sinosoft.demo.service.IMedicineInfoTempService;
import org.springframework.stereotype.Service;

/**
 * @author hiYuzu
 * @version V1.0
 * @date 2022/8/7 22:30
 */
@Service("medicineInfoTempService")
@DS("doris")
public class MedicineInfoTempServiceImpl extends ServiceImpl<MedicineInfoTempMapper, MedicineInfoTemp> implements IMedicineInfoTempService {
}
