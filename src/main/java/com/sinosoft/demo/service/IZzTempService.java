package com.sinosoft.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.sinosoft.demo.entity.ZzTemp;

import java.util.List;

/**
 * @author hiYuzu
 * @version v1.0
 * @date 2022/9/3 0:01
 */
public interface IZzTempService extends IService<ZzTemp> {
    void updateSourceData(String tableName, String pxhsjhm);
    void updateSourceData(String tableName, List<ZzTemp> zzTemps);
}
