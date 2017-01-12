//package com.thunisoft.domain;
//
//import org.springframework.security.core.authority.AuthorityUtils;
//import org.springframework.security.core.userdetails.*;
//
///**
// * Created by yhan219 on 2017/1/11.
// */
//public class CurrentUser extends org.springframework.security.core.userdetails.User {
//
//    private User user;
//
//    public CurrentUser(User user) {
//        super(user.getId(), user.getPassword(),
//                AuthorityUtils.createAuthorityList(user.getRole().toString()));
//        this.user = user;
//    }
//
//    public User getUser() {
//        return user;
//    }
//
//    public String getId() {
//        return user.getId();
//    }
//
//    public Integer getRole() {
//        return user.getRole();
//    }
//
//    @Override
//    public String toString() {
//        return "CurrentUser{" +
//                "user=" + user +
//                "} " + super.toString();
//    }
//
//}
