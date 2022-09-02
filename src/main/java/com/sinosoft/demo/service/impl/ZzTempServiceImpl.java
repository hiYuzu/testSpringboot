package com.sinosoft.demo.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sinosoft.demo.entity.ZzTemp;
import com.sinosoft.demo.mapper.ZzTempMapper;
import com.sinosoft.demo.service.IZzTempService;
import org.springframework.stereotype.Service;

/**
 * @author hiYuzu
 * @version v1.0
 * @date 2022/9/3 0:01
 */
@Service("zzTempService")
@DS("risk")
public class ZzTempServiceImpl extends ServiceImpl<ZzTempMapper, ZzTemp> implements IZzTempService {
    @Override
    public void updateSourceData(String tableName, String pxhsjhm) {
        baseMapper.updateSourceData(tableName, pxhsjhm);
    }
}
