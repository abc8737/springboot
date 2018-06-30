package com.springboot.bean;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * Created by YRP-Laptop on 2018/4/30.
 */
@Component
@ConfigurationProperties(prefix = "pc.address")
@PropertySource(value = "classpath:application-beans.properties")
public class PcAddress {

    private String ip;
    private String port;

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }
}
