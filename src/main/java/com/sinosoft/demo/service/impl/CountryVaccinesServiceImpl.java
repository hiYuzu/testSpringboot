package com.sinosoft.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sinosoft.demo.entity.CountryVaccines;
import com.sinosoft.demo.mapper.CountryVaccinesMapper;
import com.sinosoft.demo.service.ICountryVaccinesService;
import org.springframework.stereotype.Service;

/**
 * @author hiYuzu
 * @version V1.0
 * @date 2022/9/13 14:32
 */
@Service("countryVaccinesService")
public class CountryVaccinesServiceImpl extends ServiceImpl<CountryVaccinesMapper, CountryVaccines> implements ICountryVaccinesService {
}
