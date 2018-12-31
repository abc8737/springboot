package com.springboot.domain;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

/**
 * Created by SYSTEM on 2018/7/14.
 */
public class User implements Serializable {

    private Integer id;
    private String username;
    private String realname;
    private String password;
    private String rpassword;
    private Timestamp addtime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getRpassword() {
        return rpassword;
    }

    public void setRpassword(String rpassword) {
        this.rpassword = rpassword;
    }

    public Timestamp getAddtime() {
        return addtime;
    }

    public void setAddtime(Timestamp addtime) {
        this.addtime = addtime;
    }

    public String toLogString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append("id=").append(id)
                .append(";username=").append(username)
                .append(";realname=").append(realname)
                .append(";addtime=").append(new SimpleDateFormat().format(addtime));
        return buffer.toString();
    }
}
