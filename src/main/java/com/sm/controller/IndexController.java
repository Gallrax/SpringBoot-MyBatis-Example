package com.sm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2017/7/5.
 */
@Controller
public class IndexController {

    @RequestMapping("/testError")
    public void error() throws Exception {
        throw new Exception("----- this is Exception -----");
    }

}
