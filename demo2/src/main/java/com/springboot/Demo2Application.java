package com.springboot;

import com.springboot.bean.PcAddress;
import com.springboot.bean.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Demo2Application {

    // 这种注册模式可以将字段信息注入
   /* @Value(value = "${user.name}")
    private String userName;

    @Value(value = "${user.age}")
    private Integer userAge;

    @Value(value = "${user.gender}")
    private String userGender;*/

    @Autowired
    private User user;

    @Autowired
    private PcAddress pcAddress;

    public static void main(String[] args) {
        SpringApplication.run(Demo2Application.class, args);
    }

    @RequestMapping(value = "/", produces = "text/plain;charset=UTF-8")
    String index() {
        return "Hello Spring boot!\n";
    }

    @RequestMapping(value = "/user", produces = "text/plain;charset=UTF-8")
    public String user() {
        StringBuilder builder = new StringBuilder();
        builder.append("用户真实姓名：").append(user.getNames()).append(";年龄：").append(user.getAge()).append(";性别：").append(user.getGender());

        return builder.toString();
    }

    @RequestMapping(value = "/address", produces = "text/plain;charset=UTF-8")
    public String address() {
        StringBuilder builder = new StringBuilder();
        // pc地址
        builder.append("改程序启动IP地址：").append(pcAddress.getIp()).append(";启动端口:").append(pcAddress.getPort());

        return builder.toString();
    }
}
