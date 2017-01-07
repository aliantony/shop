package com.thunisoft.mapper;

import com.thunisoft.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by yhan219 on 2017/1/7.
 */
@Mapper
public interface UserMapper {

    int save(User user);

    User selectById(String id);

    int updateById(User user);

    int deleteById(String id);

    List<User> queryAll();

}