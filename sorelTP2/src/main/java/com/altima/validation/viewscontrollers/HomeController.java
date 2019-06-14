package com.altima.validation.viewscontrollers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    MessageSource messageSource;

    @GetMapping({"/"})
    public String hello(Model model) {
     return "home";
    }
}