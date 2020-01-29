package com.altima.validation.viewscontrollers;

import com.altima.validation.utilis.MessagesHelp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * HomeController class use to manage home page
 *
 * @author sorelus Mkounga
 */
@Controller
public class HomeController {

    @Autowired
    private MessagesHelp message;


    /**
     * Use to show home page
     * @return home page
     */
    @GetMapping({"/"})
    public String home() {
        return "home";
    }

    /**
     * Use to show login page
     * @return login page
     */
    @GetMapping("login")
    public String login(Model model, String error, String logout) {

        if (error != null)
            model.addAttribute("error", message.get("login.error.value"));

        if (logout != null)
            model.addAttribute("message",  message.get("login.logout.value"));

        return "login";
    }
}