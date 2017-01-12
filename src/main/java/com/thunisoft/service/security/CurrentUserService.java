//package com.thunisoft.service.security;
//
//import com.thunisoft.domain.CurrentUser;
//import com.thunisoft.domain.User;
//import com.thunisoft.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
///**
// * Created by yhan219 on 2017/1/11.
// */
//@Service
//public class CurrentUserService implements UserDetailsService {
//
//    @Autowired
//    private UserService userService;
//
//    @Override
//    public CurrentUser loadUserByUsername(String id) throws UsernameNotFoundException {
//        User user = userService.getUserById(id).orElseThrow(() -> new UsernameNotFoundException(String.format("id为%s的用户不存在", id)));
//        return new CurrentUser(user);
//    }
//
//    public boolean canAccessUser(CurrentUser user,String userId){
//        return user != null && (user.getRole()==1 || user.getId().equals(userId));
//    }
//
//}
