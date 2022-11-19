package com.sinosoft.demo.task;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.sinosoft.demo.entity.ContactPerson;
import com.sinosoft.demo.entity.InquiryInfo;
import com.sinosoft.demo.service.IInquiryInfoService;
import com.sinosoft.demo.util.GlobalUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * @author hiYuzu
 * @version V1.0
 * @date 2022/8/30 13:42
 */
@Slf4j
@Component
public class TestTask {
    @Resource
    private IInquiryInfoService inquiryInfoService;
//    @PostConstruct
    public void test() {
        log.info("同步上个小时的流调密接数据...");
        Calendar calendar1h10 = Calendar.getInstance();
        Calendar calendar10 = Calendar.getInstance();
        calendar1h10.add(Calendar.HOUR, -1);
        calendar1h10.add(Calendar.MINUTE, -10);
        calendar10.add(Calendar.MINUTE, -10);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String startTime = sdf.format(calendar1h10.getTime());
        String endTime = sdf.format(calendar10.getTime());

        QueryWrapper<InquiryInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("status", 0);
        queryWrapper.ne("contact_card_no", "");
        queryWrapper.ge("gmt_update", startTime).lt("gmt_update", endTime);
        queryWrapper.eq("person_type", "密接");
        queryWrapper.select("UPPER(contact_card_no) AS contact_card_no", "contact_card_type", "contact_person_name", "last_contact_time");
        List<InquiryInfo> inquiryInfos = inquiryInfoService.list(queryWrapper);
        log.info("数据量1："  + inquiryInfos.size());
        List<ContactPerson> result = convertClosePerson2(inquiryInfos);
        log.info("数据量2："  + result.size());
    }

    private List<ContactPerson> convertClosePerson2(List<InquiryInfo> inquiryInfos) {
        List<ContactPerson> result = new ArrayList<>();
        for (InquiryInfo info : inquiryInfos) {
            String zjlx = GlobalUtil.ZJLX_MAP.get(info.getContactCardNo());
            if (zjlx == null) {
                continue;
            }
            ContactPerson temp = new ContactPerson();
            temp.setIdentity(info.getContactCardNo());
            temp.setZjlx(zjlx);
            temp.setName(info.getContactPersonName());
            temp.setExposeTime(info.getLastContactTime());
            temp.setType("14");
            result.add(temp);
        }
        return result;
    }
}
