package com.springboot.web;

import com.springboot.domain.User;
import com.springboot.service.MailService;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by YRP-Laptop on 2018/5/1.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private MailService mailService;

    @RequestMapping(value = "/addUser")
    public String addUser(@RequestParam("name") String name, @RequestParam("age") String age) {
        int num = userService.addUser(name, age);
        if (num == 1)
//            return "Insert Successful";
            return "redirect:/allUser";
        else
            return "Insert Error";
    }

    /**
     * 访问地址格式：http://localhost:8080/findUser?id=3
     * @RequestParam("id")
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value = "/findUser")
    public String findUser(Model model, @RequestParam("id") String id) {
        User user = userService.findById(id);
        model.addAttribute("userList", user);
        return "index";
    }

    /**
     * 访问地址格式：http://localhost:8080/findUserById/3
     * @PathVariable("id")  地址访问风格类似于Restful
     * @param model
     * @param id
     * @return
     */
    @RequestMapping(value = "/findUserById/{id}")
    public String findUserById(Model model, @PathVariable("id") String id) {
        User user = userService.findById(id);
        model.addAttribute("userList", user);
        return "index";
    }

    @RequestMapping(value = "/updateById")
    public String updateById(@RequestParam("id") String id, @RequestParam("name") String name) {
        try {
            userService.updataById(id, name);
        } catch (Exception e) {
            return "error";
        }
//        return "success";
        return "redirect:/allUser";
    }

    @RequestMapping(value = "/deleteById")
    public String deleteById(@RequestParam("id") String id) {
        try {
            userService.deleteById(id);
        } catch (Exception e) {
            return "error";
        }
        return "redirect:/allUser";
    }

    @RequestMapping(value = "/allUser")
    public String findAllUser(Model model) {
        List<User> userList = userService.findAllUser();
        model.addAttribute("userList", userList);

        StringBuilder builder = new StringBuilder();
        for (User user : userList) {
            if (user != null) {
                builder.append(user.toString()).append("<br>");
            }
        }
        String content = builder.toString();
//        sendMail(content);

        return "index";
    }

    public void sendMail(String content) {
        String mailTo = "873750200@qq.com";
        String subject = "springboot测试邮件发送福利！";
        mailService.sendHtmlMail(mailTo, subject, content);
    }
}
