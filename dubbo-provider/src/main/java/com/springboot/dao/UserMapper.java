package com.springboot.dao;

import com.springboot.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Created by YRP-Laptop on 2018/8/18.
 */
@Mapper
public interface UserMapper {

    @Select("select * from users")
    List<User> allUsers();

    @Select("select t from users t where t.id=#{id}")
    User getUserById(@Param("id") Long id);

    /**
     * 用户登录
     * @param username
     * @param password
     * @return
     */
    @Select("select t from users t where upper(t.username)=upper(#{username}) and t.password=#{password}")
    boolean login(@Param("username") String username, @Param("password") String password);

    /**
     * 用户注册
     * @param username
     * @param realname
     * @param password
     * @param repassword
     * @param gender
     * @param age
     */
    @Insert("insert into users(username,realname,password,repassword,gender,age) values(#{username},#{realname},#{password},#{repassword}.#{gender},#{age})")
    int register(@Param("username") String username, @Param("realname") String realname, @Param("password") String password,
                  @Param("repassword") String repassword, @Param("gender") String gender, @Param("age") Integer age);

    /**
     * 用户销户
     * @param id
     * @return
     */
    @Delete("delete from users where id=#{id}")
    boolean cancelCount(Long id);

}
