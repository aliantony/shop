package com.thunisoft.controller;

import com.thunisoft.domain.User;
import com.thunisoft.repository.UserMapper;
import com.thunisoft.service.UserService;
import com.thunisoft.utils.ShopUUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

/**
 * Created by yhan219 on 2017/1/7.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserService userService;

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
    public ModelAndView userList(){
        return new ModelAndView("/user/list","users",userMapper.queryAll());
    }

    @RequestMapping("/test")
    public @ResponseBody String sessionTest(HttpSession session){
        session.setAttribute("user","张三");
        return "test";
    }

    @RequestMapping("/headers")
    public @ResponseBody String headerTest(@RequestHeader HttpHeaders headers){
        return headers.toString();
    }


    @RequestMapping("/user/test.json")
    public @ResponseBody User userTest(String id) {
        User user = userService.getUserById(id);
        if(user==null){
            throw new NullPointerException("用户不存在");
        }
        return user;
        /*Optional<User> user = Optional.of(userService.getUserById(id));
        return user.orElseThrow(() -> new NullPointerException(String.format("id异常，id：%s",user.get().getId())));
        */
    }

}
