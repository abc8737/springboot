package com.springboot;

import com.springboot.service.CityController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class DubboConsumerApplication {

    public static CityController cityController;

    public static void main(String[] args) {

//		SpringApplication.run(DubboConsumerApplication.class, args);
        // 程序启动入口
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
        ConfigurableApplicationContext run = SpringApplication.run(DubboConsumerApplication.class, args);
        cityController = run.getBean(CityController.class);
        cityController.printCity();
        String content = cityController.getCities();
        System.err.println(content);
    }

    @RequestMapping(value = "/index")
    public String index() throws Exception {
        String cityList = cityController.getCities();
        return cityList;
    }


}


