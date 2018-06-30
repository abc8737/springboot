package com.springboot.domain;

/**
 * Created by YRP-Laptop on 2018/5/1.
 */
public class User {

    private String id;
    private String name;
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    /*@Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
    }*/

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();
        builder.append("序号：").append(id)
                .append(";姓名：").append(name)
                .append(";年龄：").append(age);
        return builder.toString();

    }
}