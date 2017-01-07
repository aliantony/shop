package com.thunisoft.controller;

import com.thunisoft.mapper.UserMapper;
import com.thunisoft.pojo.User;
import com.thunisoft.utils.ShopUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by yhan219 on 2017/1/7.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/add.html")
    public String add(){
        return "/user/add";
    }

    @RequestMapping("/doAdd")
    public String addUser(User user){
        user.setId(ShopUUID.getUUID());
        userMapper.save(user);
        return "redirect:/user/list.html";
    }

    @GetMapping("/list.html")
    public String userList(Model model){
        model.addAttribute("users",userMapper.queryAll());
        return "/user/list";
    }
}
