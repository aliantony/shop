package com.thunisoft.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by yhan219 on 2017/1/12.
 */
@ControllerAdvice
public class ShopControllerAdvice {

    @ExceptionHandler(NullPointerException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView userIdExcetion(NullPointerException e){
        return new ModelAndView("/error","error",e.getMessage());
    }
}
