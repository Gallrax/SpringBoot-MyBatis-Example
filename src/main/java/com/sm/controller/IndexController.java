package com.sm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Gallrax on 2017/7/5.
 */
@Controller
public class IndexController {

    @RequestMapping("/testError")
    public void error() {
        throw new RuntimeException("----- this is Exception -----");
    }

    @RequestMapping("/index.html")
    public String index() {
        return "index";
    }

}
