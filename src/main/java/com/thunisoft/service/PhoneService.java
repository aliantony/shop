package com.thunisoft.service;

import com.thunisoft.mapper.PhoneMapper;
import com.thunisoft.domain.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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

    @Cacheable(value = "phonePageList",key = "#page+#pageSize")
    public List<Phone> getPage(int page,int pageSize){
        System.out.println("没有经过缓存");
        int start = (page - 1)*pageSize;
        return phoneMapper.getPage(start,pageSize);
    }

    @CacheEvict(value = "phoneList",key = "#id")
    public void deltePhone(String id){
        phoneMapper.deleteById(id);
    }

    @CachePut(value = "phone",key = "#phone.id")
    public Phone addPhone(Phone phone){
        phoneMapper.save(phone);
        return phone;
    }

}
