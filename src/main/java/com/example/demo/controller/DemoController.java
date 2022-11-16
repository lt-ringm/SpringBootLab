package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

    @Value("${spring.application.name}")
    String appName;

    // HOME PAGE
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("appName", appName);
        return "home";
    }

    @RequestMapping("/check")
    public String check(Model model){
        return "check";
    }
}
