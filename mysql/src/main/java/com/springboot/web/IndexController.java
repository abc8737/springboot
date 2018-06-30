package com.springboot.web;

import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by YRP-Laptop on 2018/5/1.
 */
@Controller
public class IndexController {

    @Autowired
    private UserService userService;

    /*@RequestMapping(value = "/indexPage")
    public String getIndex(HashMap<String, String> map, HttpServletRequest request) {
        map.put("hello", "欢迎进入HTML页面");
        List<User> userList = userService.findAllUser();
        request.setAttribute("userList", userList);
        return "/index";
    }*/
}
