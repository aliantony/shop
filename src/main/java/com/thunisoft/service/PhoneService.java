package com.thunisoft.service;

import com.thunisoft.mapper.PhoneMapper;
import com.thunisoft.pojo.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yhan219 on 2017/1/7.
 */
@Service
public class PhoneService {

    @Autowired
    private PhoneMapper phoneMapper;

    @Transactional
    public void saveAll(List<Phone> phones){
        for (Phone p : phones){
            phoneMapper.save(p);
        }
    }

}
