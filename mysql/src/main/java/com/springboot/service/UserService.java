package com.springboot.service;

import com.springboot.dao.UserMapper;
import com.springboot.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by YRP-Laptop on 2018/5/1.
 */
@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User findById(String id) {
        return userMapper.findById(id);
    }

    public int addUser(String name, String age) {
        return userMapper.addUser(name, age);
    }

    public void updataById(String id, String name) {
        userMapper.updataById(id, name);
    }

    public void deleteById(String id) {
        userMapper.deleteById(id);
    }

    public List<User> findAllUser() {
        return userMapper.findAllUser();
    }
}
