package com.sinosoft.demo.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sinosoft.demo.entity.LzlTaskEntity;
import com.sinosoft.demo.mapper.LzlTaskMapper;
import com.sinosoft.demo.service.ILzlTaskService;
import org.springframework.stereotype.Service;

/**
 * @author hiYuzu
 * @version V1.0
 * @date 2022/11/11 10:53
 */
@Service("lzlTaskService")
@DS("local")
public class LzlTaskServiceImpl extends ServiceImpl<LzlTaskMapper, LzlTaskEntity> implements ILzlTaskService {
}
