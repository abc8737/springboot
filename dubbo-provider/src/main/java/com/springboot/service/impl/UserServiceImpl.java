package com.springboot.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.springboot.dao.UserMapper;
import com.springboot.domain.User;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by YRP-Laptop on 2018/8/18.
 */
@Service(version = "1.0.0")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAllUsers() {
        return userMapper.allUsers();
    }

    @Override
    public User findUserById(Long id) {
        return null;
    }

    @Override
    public boolean findUserByNamePwd(String username, String password) {
        return userMapper.login(username, password);
    }

    @Override
    public void insertUser(User user) {

    }

    @Override
    public int addUser(User user) {
        return userMapper.register(user.getUsername(), user.getRealname(), user.getPassword(), user.getRepassword(), user.getGender(), user.getAge());
    }

    @Override
    public void updateUser(User user) {

    }

    @Override
    public void deleteUser(User user) {

    }

    @Override
    public boolean deleteUser(Long id) {
        User user = userMapper.getUserById(id);
        if (user == null) {
            return false;
        } else
            return userMapper.cancelCount(id);
    }
}
