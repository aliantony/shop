package com.thunisoft.controller;

import com.thunisoft.domain.Phone;
import com.thunisoft.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.solr.core.query.result.HighlightPage;
import org.springframework.data.solr.repository.Highlight;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by yhan219 on 2017/1/8.
 */
@Controller
@RequestMapping("/phone")
public class PhoneController {

    @Autowired
    private PhoneService phoneService;

    @RequestMapping("/list/page-{page}.html")
    public String list(@PathVariable int page, Model model){
        model.addAttribute("phones",phoneService.getPage(page,20));
        return "/phone/list";
    }

    @GetMapping("/list/all.json")
    public @ResponseBody
    List<Phone> getAll(){
        return phoneService.getAllFromSolr();
    }

    @GetMapping("/list/phonename-{phonename}.json")
    public @ResponseBody Page<Phone> getByPhonename(@PathVariable String phonename,@PageableDefault(value = 15,sort = {"id"},direction = Sort.Direction.DESC) Pageable pageable){
        return phoneService.getByPhonename(phonename,pageable);
    }

    @GetMapping("/list/cnum-{cnum}.json")
    public @ResponseBody
    HighlightPage<Phone> getByCnum(@PathVariable String cnum, @PageableDefault(value = 15,sort = {"id"},direction = Sort.Direction.DESC) Pageable pageable){
        return phoneService.getByCnum(cnum,pageable);
    }

    @GetMapping("/solr/{id}")
    public @ResponseBody Phone getOne(@PathVariable String id){
        return phoneService.getByIdFromSolr(id);
    }

}
