package com.thunisoft.service;

import com.thunisoft.repository.PhoneMapper;
import com.thunisoft.repository.solr.SolrPhoneRepository;
import com.thunisoft.domain.Phone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yhan219 on 2017/1/7.
 */
@Service
public class PhoneService {

    @Autowired
    private PhoneMapper phoneMapper;

    @Autowired
    private SolrPhoneRepository solrPhoneRepository;

    @Transactional
    public void saveAll(List<Phone> phones){
        phones.forEach(phone -> {
            phoneMapper.save(phone);
            solrPhoneRepository.save(phones);
        });
    }

    public List<Phone> getAllFromSolr(){
        List<Phone> list = new ArrayList<>();
        solrPhoneRepository.findAll().forEach(phone -> list.add(phone));
        return list;
    }

    public Phone getByIdFromSolr(String id){
       return solrPhoneRepository.findOne(id);
    }

    public Page<Phone> getByPhonename(String phonename, Pageable pageable){
        return solrPhoneRepository.findByPhonename(phonename,pageable);
    }

    @Cacheable(value = "phonePageList",key = "#page+#pageSize")
    public List<Phone> getPage(int page,int pageSize){
        System.out.println("没有经过缓存");
        return phoneMapper.getPage((page - 1)*pageSize,pageSize);
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

    public HighlightPage<Phone> getByCnum(String cnum, Pageable pageable) {
        return solrPhoneRepository.findByCnum(cnum,pageable);
    }
}
