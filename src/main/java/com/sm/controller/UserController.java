package com.sm.controller;

import com.sm.entity.User;
import com.sm.service.UserSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String findById(@PathVariable Integer id, ModelMap model) {
        User user = userSer.findById(id);
        model.addAttribute("user", user);
        return "userManage";
    }

    @RequestMapping("/addUser")
    public String addUser(User user) {
        userSer.addUser(user);
        return "userManage";
    }
}