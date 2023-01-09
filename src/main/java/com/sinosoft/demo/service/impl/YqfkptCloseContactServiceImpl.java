package com.sinosoft.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.sinosoft.demo.entity.YqfkptCloseContact;
import com.sinosoft.demo.mapper.YqfkptCloseContactMapper;
import com.sinosoft.demo.service.IYqfkptCloseContactService;
import org.springframework.stereotype.Service;

/**
 * @author hiYuzu
 * @version V1.0
 * @date 2022/9/13 14:32
 */
@Service("yqfkptCloseContactService")
public class YqfkptCloseContactServiceImpl extends ServiceImpl<YqfkptCloseContactMapper, YqfkptCloseContact> implements IYqfkptCloseContactService {
}
