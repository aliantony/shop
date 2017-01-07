package com.thunisoft.mapper;

import com.thunisoft.pojo.User;
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
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSave(){
        User user = new User();
        user.setId("123");
        user.setPassword("123");
        user.setTel("123");
        user.setUsername("123");
        userMapper.save(user);
    }

}
