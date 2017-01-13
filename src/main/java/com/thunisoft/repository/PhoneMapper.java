package com.thunisoft.repository;

import com.thunisoft.domain.Phone;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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

    List<Phone> getPage(@Param("start") int start, @Param("pageSize") int pageSize);

}