package com.springboot.controller;

import com.springboot.domain.User;
import com.springboot.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;
import java.util.List;

/**
 * Created by SYSTEM on 2018/7/14.
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping(value = "/all")
    public String getAllUsers(Model model) {
        List<User> userList = userMapper.findAllUser();
        model.addAttribute("userList", userList);
        return "userList";
    }

    @RequestMapping(value = "/index")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/addOne")
    public String addUser(HttpServletRequest request) {
        String username = request.getParameter("username");
        String realname = request.getParameter("realname");
        String pwd = request.getParameter("password");
        String repwd = request.getParameter("rpassword");
        if (!pwd.equals(repwd))
            return "error";
        User user = new User();
        user.setUsername(username);
        user.setRealname(realname);
        user.setPassword(pwd);
        user.setRpassword(repwd);
        user.setAddtime(new Timestamp(System.currentTimeMillis()));
        userMapper.addUser(user);
        return "redirect:/user/all";
    }

    @RequestMapping(value = "/deleteById")
    public String deleteById(HttpServletRequest request) {
        String id = request.getParameter("id");
        int count = 0;
        if (!StringUtils.isEmpty(id)) {
            count = userMapper.deleteUserById(Long.parseLong(id));
        }

        if (count == 1) {
            return "redirect:/user/all";
        } else {
            return "error";
        }
    }

    @RequestMapping(value = "/locate")
    public String location() {
        return "locate";
    }

}
