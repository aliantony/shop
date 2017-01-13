package com.thunisoft.controller;

import com.thunisoft.domain.Phone;
import com.thunisoft.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/list/solr")
    public @ResponseBody
    List<Phone> getAll(){
        return phoneService.getAllFromSolr();
    }

}
