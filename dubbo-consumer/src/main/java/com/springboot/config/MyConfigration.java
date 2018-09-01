package com.springboot.config;

import com.springboot.DubboConsumerApplication;
import com.springboot.service.CityController;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 创建各种配置
 *暂时用不到此配置类
 * Created by SYSTEM on 2018/7/8.
 */
public class MyConfigration {

    private ConfigurableApplicationContext context;

    public MyConfigration(ConfigurableApplicationContext context) {
        context = SpringApplication.run(DubboConsumerApplication.class,new String[]{});
        this.context = context;
    }

    public CityController init(CityController cityController) {
        context = SpringApplication.run(DubboConsumerApplication.class);
        cityController = context.getBean(CityController.class);
        return cityController;
    }
}
