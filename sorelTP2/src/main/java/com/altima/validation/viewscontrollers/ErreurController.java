package com.altima.validation.viewscontrollers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller
public class ErreurController implements ErrorController {

    @RequestMapping("/error")
    public String handleError(Model model, HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        Integer statusCode = 0;
        if (status != null)
            statusCode = Integer.valueOf(status.toString());

        model.addAttribute("code",statusCode);

        return "/error";
    }
 
    @Override
    public String getErrorPath() {
        return "/error";
    }
}