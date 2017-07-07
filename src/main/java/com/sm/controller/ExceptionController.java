package com.sm.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * Created by Gallrax on 2017/7/6.
 */
@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(value = Exception.class)
    public String error(Model model, Exception e) {
        e.printStackTrace();
        model.addAttribute("message", e.getMessage());
        return "error";
    }
}
