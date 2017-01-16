package com.thunisoft.repository.solr;

import com.thunisoft.domain.Phone;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.data.solr.repository.Highlight;
import org.springframework.data.solr.repository.SolrCrudRepository;

/**
 * Created by yhan219 on 2017/1/12.
 */
public interface SolrPhoneRepository extends SolrCrudRepository<Phone,String> {
    //List<Phone> findByNameStartingWith(String name);
    @Highlight
    HighlightPage<Phone> findByPhonename(String phonename, Pageable page);

    @Highlight
    HighlightPage<Phone> findByCnum(String cnum, Pageable page);





}
