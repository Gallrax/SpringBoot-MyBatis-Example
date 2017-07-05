package com.sm.controller;

import org.springframework.stereotype.Controller;

/**
 * Created by Administrator on 2017/7/5.
 */
@Controller
public class IndexController {

//    @RequestMapping("/")
    public String index() {
        return "index";
    }
}
