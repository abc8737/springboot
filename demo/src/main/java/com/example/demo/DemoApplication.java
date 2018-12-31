package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

    @RequestMapping(value = "/")
    public String index() {
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
        return "Hello Spring boot demo\n" + format.format(new Date(System.currentTimeMillis()));
    }

    @RequestMapping(value = "/call")
//    @ResponseBody
    public void call(HttpServletRequest request, HttpServletResponse response) throws Exception {
        PrintWriter writer;
        writer = response.getWriter();
        String callback = request.getParameter("jsonpCallback");
        String retVal = "";
        String jsonString = "{\"name\":\"yerenpeng\",\"age\":25,\"gender\":\"male\"}";
        if (!StringUtils.isEmpty(callback)) {
            retVal = callback + "('" + jsonString + "')";
        }
        writer.write(retVal);
        System.out.println("回调请求...");
    }
}
