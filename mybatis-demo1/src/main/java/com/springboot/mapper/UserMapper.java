package com.springboot.mapper;

import com.springboot.domain.User;

import java.util.List;

/**
 * Created by SYSTEM on 2018/7/14.
 */
public interface UserMapper {

    public List<User> findAllUser();

    public User findUserById(Long id);

    public User findUserByName(String username);

    public void addUser(User user);

    public int deleteUserById(Long id);

    public void deleteUser(User user);

}
