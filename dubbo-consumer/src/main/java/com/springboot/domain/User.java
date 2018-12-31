package com.springboot.domain;

import java.io.Serializable;

/**
 * Created by YRP-Laptop on 2018/8/18.
 */
public class User implements Serializable {

    private Long id;
    private String username;    // 用户登录名
    private String realname;    // 用户真实姓名
    private String password;    // 密码
    private String repassword;  // 再次验证密码
    private String gender;
    private Integer age;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRepassword() {
        return repassword;
    }

    public void setRepassword(String repassword) {
        this.repassword = repassword;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public User() {
    }

    public User(Long id, String username, String realname, String password, String repassword, String gender, Integer age) {
        this.id = id;
        this.username = username;
        this.realname = realname;
        this.password = password;
        this.repassword = repassword;
        this.gender = gender;
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", realname='" + realname + '\'' +
                ", password='" + password + '\'' +
                ", repassword='" + repassword + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }

}
