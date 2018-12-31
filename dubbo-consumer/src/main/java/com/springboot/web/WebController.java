package com.springboot.web;

import com.springboot.domain.City;
import com.springboot.service.CityController;
import com.springboot.service.impl.UserController;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by SYSTEM on 2018/7/8.
 * <p>
 * 使用注解注入CityController，调用实现方法获取数据
 */
@Controller
public class WebController {

    public static final String INDEX_PAGE = "index";
    public static final String LOGIN_PAGE = "login";
    public static final String REGIST_PAGE = "regist";
    public static final String ERROR_PAGE = "error";
    public static final String REMOVE_COUNT = "remove_count";
    public static final String PREFIX_REDIRECT = "redirect:/";

    // 直接注入Controller的bean实例，实现具体业务调用
    @Autowired
    private CityController cityController;

    @Autowired
    private UserController userController;


    @RequestMapping(value = "/allCity")
    public String index(Model model) {
        List<City> cityList = cityController.getCityList();
        model.addAttribute("cityList", cityList);
        return "index";
    }

    @RequestMapping(value = "/getCity/{cityName}")
    public String getCity(@PathVariable("cityName") String cityName, Model model) throws Exception {
        City city = cityController.getCityByName(cityName);
        String returnStr = city != null ? city.toString() : "您查找的城市不存在！";
        Logger logger = Logger.getLogger(WebController.class);
        logger.info(returnStr);
        model.addAttribute("info", returnStr);
        return INDEX_PAGE;
    }


    @RequestMapping(value = "/index")
    public String index_page(Model model) throws Exception {

        return "user_index";
    }

    @RequestMapping(value = "/login")
    public String login(Model model, @PathVariable("username") String username, @PathVariable("password") String password) throws Exception {
        boolean isLogin = userController.login(username, password);
        if (isLogin) {

        }

        return "user_login";
    }

}
