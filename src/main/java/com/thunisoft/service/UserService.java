package com.thunisoft.service;

import com.thunisoft.mapper.UserMapper;
import com.thunisoft.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Created by yhan219 on 2017/1/10.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    @CachePut(value = "user",key = "#user.id")
    public User addUser(User user){
        userMapper.save(user);
        return user;
    }

    public User getUserById(String id){
        return userMapper.selectById(id);
    }

}
