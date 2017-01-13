package com.thunisoft.repository;

import com.thunisoft.domain.Phone;
import org.springframework.data.solr.repository.SolrCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yhan219 on 2017/1/12.
 */
public interface PhoneSolrDao extends SolrCrudRepository<Phone,String> {
    //List<Phone> findByNameStartingWith(String name);
}
