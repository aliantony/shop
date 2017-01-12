package com.thunisoft.controller;

import com.sun.xml.internal.ws.api.message.ExceptionHasMessage;
import com.thunisoft.domain.User;
import com.thunisoft.mapper.UserMapper;
import com.thunisoft.service.UserService;
import com.thunisoft.utils.ShopUUID;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Optional;

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
    public String userList(Model model){
        model.addAttribute("users",userMapper.queryAll());
        return "/user/list";
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
    }
    /*Optional<User> user = Optional.of(userService.getUserById(id));
        return user.orElseThrow(() -> new NullPointerException(String.format("id异常，id：%s",user.get().getId())));
        */

}
