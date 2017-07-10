package com.sm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;

/**
 * Created by Gallrax on 2017/7/5.
 */
@Controller
public class IndexController {

    @RequestMapping("/testError")
    public void error() {
        throw new RuntimeException("----- this is Exception -----");
    }

    /*@RequestMapping("/index.html")
    public String index() {
        return "index";
    }*/

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "login";
    }

    @RequestMapping(value = "/loginValidate", method = RequestMethod.POST)
    public String validate(String username, String password, HttpSession session) {
        if("admin".equals(username) && "admin".equals(password)){
            session.setAttribute("username", username);
            return "index";
        }
        return "login";
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("username");
        return "login";
    }

}
