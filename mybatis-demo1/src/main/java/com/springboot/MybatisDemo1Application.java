package com.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@MapperScan("com.springboot.mapper")
@SpringBootApplication
public class MybatisDemo1Application {

    public static void main(String[] args) {
        SpringApplication.run(MybatisDemo1Application.class, args);
    }

    @RequestMapping(value = "/")
    public String index() {
        return "程序已经成功启动";
    }
}
