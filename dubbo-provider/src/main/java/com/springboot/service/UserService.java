package com.springboot.service;

import com.springboot.domain.User;

import java.util.List;

/**
 * Created by YRP-Laptop on 2018/8/18.
 */
public interface UserService {

    List<User> findAllUsers();

    User findUserById(Long id);

    boolean findUserByNamePwd(String username, String password);

    void insertUser(User user);

    /**
     * 用户注册
     * @param user
     * @return
     */
    int addUser(User user);

    void updateUser(User user);

    void deleteUser(User user);

    boolean deleteUser(Long id);

}
