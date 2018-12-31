package com.springboot;

import com.springboot.service.CityController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * main()函数是整个springboot系统的启动入口，启动调用springboot的application.properties文件内容，自动装载相关配置，
 * 装载配置之后可以在不同的WebController中操作跳转网页
 * <p>
 * dubbo-consumer中的实例bean（如City）、接口（如CityService）需要暴露和dubbo-provider中的接口暴露一致，
 * 接口实现（CityController）不同的业务就是自己需要实现的
 */
@RestController
@SpringBootApplication
public class DubboConsumerApplication {

    public static ConfigurableApplicationContext configContext;
    public static CityController cityController;

    public static void init() {
        configContext = SpringApplication.run(DubboConsumerApplication.class, new String[]{});
        cityController = configContext.getBean(CityController.class);
    }


    public static void main(String[] args) {
        //初始化启动
        init();

//		SpringApplication.run(DubboConsumerApplication.class, args);
        // 程序启动入口
        // 启动嵌入式的 Tomcat 并初始化 Spring 环境及其各 Spring 组件
//        ConfigurableApplicationContext run = SpringApplication.run(DubboConsumerApplication.class, args);
        cityController = configContext.getBean(CityController.class);
        cityController.printCity();
        String content = cityController.getCities();
        System.err.println(content);
    }

    /**
     * 项目启动入口就是这个方法xxxApplication.java的main方法，这里获取不到其他业务资源，仅仅就是项目程序启动的入口
     *
     * @return
     * @throws Exception
     */
    /*@RequestMapping(value = "/index")
    public String index() throws Exception {
        if (cityController == null)
            init();
        String cityList = cityController.getCities();
        return cityList;
    }*/

}


