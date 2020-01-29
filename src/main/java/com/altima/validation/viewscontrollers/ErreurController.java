package com.altima.validation.viewscontrollers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

/**
 * ErreurController class use for manage web app error
 *
 * @author sorelus Mkounga
 */
@Controller
public class ErreurController implements ErrorController {

    /**
     * Use to show error page
     * @param model use for exchange data with jsp page
     * @param request use to know error details
     * @return error page
     */
    @RequestMapping("/error")
    public String handleError(Model model, HttpServletRequest request) {
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        Integer statusCode = 0;
        if (status != null)
            statusCode = Integer.valueOf(status.toString());

        model.addAttribute("code", statusCode);

        return "error";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

    /**
     * Use to show access denied page
     * @return access denied page
     */
    @RequestMapping("accessDenied")
    public String accessDenied() {
        return "accessDenied";
    }
}