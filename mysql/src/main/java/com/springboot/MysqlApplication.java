package com.springboot;

import com.springboot.utils.LoggerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

import java.util.logging.Level;

@RestController
@SpringBootApplication
public class MysqlApplication {

    @Autowired
    private JedisPool jedisPool;

    public static void main(String[] args) {
//        LoggerUtils loggerUtils = new LoggerUtils(Level.INFO, "LoggerInfo...", "项目已经启动了，这是打印的Logging...");
//        loggerUtils.loggerOutput();
        SpringApplication.run(MysqlApplication.class, args);
    }


    @RequestMapping(value = "/", produces = "text/plain;charset=UTF-8")
    String index() {
        LoggerUtils loggerUtils = new LoggerUtils(Level.INFO, MysqlApplication.class.getName(), "项目已经启动了，这是打印的Logging...");
        loggerUtils.loggerOutput();
        return "Hello Spring boot!\n";
    }

    @RequestMapping(value = "/redis/{key}")
    public String testRedis(@PathVariable("key") String key) {
        Jedis jedis = jedisPool.getResource();
        return jedis.get(key);
    }

}
