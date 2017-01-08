package com.thunisoft.mapper;

import com.thunisoft.pojo.Phone;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by yhan219 on 2017/1/7.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PhoneMapperTest {

    @Autowired
    private PhoneMapper phoneMapper;

    @Test
    public void testAdd(){
        Phone phone = new Phone();
        phone.setId("123");
        phone.setDisk("128");
        phone.setMemory("2");
        phone.setPhonename("华为");
        phone.setPrice("2200");
        phone.setScreen("5.5");
        phoneMapper.save(phone);
    }

}
