package com.thunisoft.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

/**
 * Created by yhan219 on 2017/1/11.
 */
@Controller
public class LoginController {
    @GetMapping("/login.html")
    public ModelAndView login(String error){
        return new ModelAndView("/login","error",error);
    }
}
