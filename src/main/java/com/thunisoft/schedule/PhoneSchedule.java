package com.thunisoft.schedule;

import com.thunisoft.pojo.Phone;
import com.thunisoft.service.PhoneService;
import com.thunisoft.spider.JdPhoneSpider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

/**
 * Created by yhan219 on 2017/1/7.
 */
@Component
public class PhoneSchedule {

    @Autowired
    private PhoneService phoneService;

    @Scheduled(cron = "0 0/5 * * * ? ")
    public void getAndSavePhoneFromJd() throws IOException {
        List<Phone> phones = JdPhoneSpider.getAllPhone();
        phoneService.saveAll(phones);
    }
    //@Scheduled(fixedRate = 10000)
    public void test() throws IOException {
        System.out.println("定时任务执行");
    }
}
