package com.thunisoft.mapper;

import com.thunisoft.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Optional;

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