package com.thunisoft.mapper;

import com.thunisoft.pojo.Phone;
import com.thunisoft.pojo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by yhan219 on 2017/1/7.
 */
@Mapper
public interface PhoneMapper {

    int save(Phone phone);

    Phone selectById(String id);

    int updateById(Phone phone);

    int deleteById(String id);

    List<Phone> queryAll();

}