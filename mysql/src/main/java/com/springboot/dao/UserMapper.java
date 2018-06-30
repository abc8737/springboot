package com.springboot.dao;

import com.springboot.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by YRP-Laptop on 2018/5/1.
 */
@Mapper
public interface UserMapper {

    @Insert("insert into user(name,age) values(#{name},#{age})")
    int addUser(@Param("name") String name, @Param("age") String age);

    @Select("select * from user where id =#{id}")
    User findById(@Param("id") String id);

    @Update("update user set name=#{name} where id=#{id}")
    void updataById(@Param("id") String id, @Param("name") String name);

    @Delete("delete from user where id=#{id}")
    void deleteById(@Param("id") String id);

    @Select("select * from user")
    List<User> findAllUser();

}