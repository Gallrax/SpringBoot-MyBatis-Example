package com.sm.controller;

import com.sm.entity.User;
import com.sm.service.UserSer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
    public String userManage(Model model) {
        List<User> users = userSer.findAll();
        model.addAttribute("users", users);
        return "userManage";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public String findById(@PathVariable Integer id, Model model) {
        if (id == 0) return "addAndUpdateUser";
        User user = userSer.findById(id);
        model.addAttribute("user", user);
        return "addAndUpdateUser";
    }

    @RequestMapping(value = "/addAndUpdateUser", method = RequestMethod.POST)
    public String addUser(User user) {
        if (user.getId() == null) {
            userSer.addUser(user);
        } else {
            userSer.updateUser(user);
        }
        return "redirect:/userManage";
    }

    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
    public String deleteUser(@PathVariable Integer id) {
        userSer.deleteUser(id);
        return "redirect:/userManage";
    }
}