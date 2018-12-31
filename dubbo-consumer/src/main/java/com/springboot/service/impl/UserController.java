package com.springboot.service.impl;

import com.alibaba.dubbo.config.annotation.Reference;
import com.springboot.domain.User;
import com.springboot.service.UserService;
import org.springframework.stereotype.Component;

/**
 * Created by YRP-Laptop on 2018/8/18.
 */
@Component
public class UserController {

    @Reference(version = "1.0.0")
    UserService userService;

    public boolean login(String username, String password) {
        return userService.findUserByNamePwd(username, password);
    }

    public int regist(User user) {
        return userService.addUser(user);
    }

    public boolean removeCount(Long id) {
        return userService.deleteUser(id);
    }

}
