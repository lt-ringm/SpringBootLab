package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

    @Value("${spring.application.name}")
    String appName;

    /*
    Home page

    @param model: model

    @return: home page name
     */
    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("appName", appName);
        return "home";
    }

    /*
    Check if you have won page

    @param model: model

    @return: check page name
     */
    @RequestMapping("/check")
    public String check(Model model){
        return "check";
    }

    /*
    Buy a new scratch&win page

    @param model: model

    @return: buy page name
     */
    @RequestMapping("/buy")
    public String buy(Model model){
        return "buy";
    }

    /*
    Admin sign in page

    @param model: model

    @return: admin page name
     */
    @RequestMapping("/admin")
    public String admin(Model model){
        return "admin";
    }
}
