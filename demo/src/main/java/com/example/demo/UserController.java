package com.example.demo;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

/**
 * Created by YRP-Laptop on 2018/5/3.
 */
@Controller
public class UserController {

    @RequestMapping(value = "/getPage")
    public String getPage(HashMap<String, String> map) throws Exception {

        /*map.put("content", "I am yerenpeng");
        String jsonStr = "[{\"CityId\":18,\"CityName\":\"西安\",\"ProvinceId\":27,\"CityOrder\":1}," +
                "{\"CityId\":53,\"CityName\":\"广州\",\"ProvinceId\":27,\"CityOrder\":1}]";
        map.put("citys",jsonStr);*/

        ObjectMapper mapper = new ObjectMapper();
        String string = mapper.writeValueAsString("");

        return "/page";
    }
}
