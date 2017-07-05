package com.sm.controller;

import com.sm.entity.User;
import com.sm.service.UserSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by Administrator on 2017/7/5.
 */
@Controller
public class UserController {

    @Autowired
    private UserSer userSer;

    @RequestMapping("/userManage")
    public String index(ModelMap model) {
        List<User> users = userSer.findAll();
        System.out.println(users);
        model.addAttribute("users", users);
        return "userManage";
    }

    @RequestMapping("/addUser")
    public String addUser(User user) {
        userSer.addUser(user);
        return "userManage";
    }
}