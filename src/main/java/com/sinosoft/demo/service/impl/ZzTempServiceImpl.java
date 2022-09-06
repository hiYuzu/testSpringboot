package com.sinosoft.demo.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sinosoft.demo.entity.ZzTemp;
import com.sinosoft.demo.mapper.ZzTempMapper;
import com.sinosoft.demo.service.IZzTempService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author hiYuzu
 * @version v1.0
 * @date 2022/9/3 0:01
 */
@Slf4j
@Service("zzTempService")
@DS("risk")
public class ZzTempServiceImpl extends ServiceImpl<ZzTempMapper, ZzTemp> implements IZzTempService {
    @Override
    public void updateSourceData(String tableName, String pxhsjhm) {
        baseMapper.updateSourceData(tableName, pxhsjhm);
    }

    @Override
    public void updateSourceData(String tableName, List<ZzTemp> zzTemps) {
        int size = zzTemps.size();
        if (size > 0) {
            log.info(tableName + "表共" + size + "条数据。");
            baseMapper.updateSourceDataList(tableName, zzTemps);
        } else {
            log.info(tableName + "表无数据。");
        }
    }
}
