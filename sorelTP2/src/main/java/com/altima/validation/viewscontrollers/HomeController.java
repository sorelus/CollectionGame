package com.altima.validation.viewscontrollers;

import com.altima.validation.utilis.MessagesHelp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.LocaleResolver;

@Controller
public class HomeController {

    @Autowired
    private MessagesHelp message;


    @GetMapping({"/"})
    public String home() {
        return "home";
    }

    @GetMapping("login")
    public String login(Model model, String error, String logout) {

        if (error != null)
            model.addAttribute("error", message.get("login.error.value"));

        if (logout != null)
            model.addAttribute("message",  message.get("login.logout.value"));

        return "login";
    }
}