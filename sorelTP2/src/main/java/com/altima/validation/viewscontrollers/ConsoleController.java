package com.altima.validation.viewscontrollers;


import com.altima.validation.App;
import com.altima.validation.dtos.entities.ConsoleDto;
import com.altima.validation.services.ConsoleService;
import com.altima.validation.utilis.JeuException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;

@Controller
public class ConsoleController {
    @Autowired
    ConsoleService consoleService;

    String modelAttribListConsole = "consoles";
    @GetMapping({"/create_console"})
    public String create(Model model,@RequestParam (value="console", required=false)String consoleName) {
        ConsoleDto console = null;
        try {
            List<ConsoleDto> consoles = consoleService.getAllOrderByDate();
            model.addAttribute(modelAttribListConsole, consoles);

            if (consoleName != null && consoleName.length() != 0) {
                console = consoleService.getConsoleByName(consoleName);
            }
        }catch (JeuException ex){
            App.APPLOGGER.log(Level.SEVERE,ex.getMessage());
        }
        if(console==null)
            console =new ConsoleDto();
        model.addAttribute("editConsole",console);

        return "console/create_console";
    }

    @PostMapping({"/create_console"})
    public String edit( @ModelAttribute("editConsole")ConsoleDto console, Model model) {
        boolean consoleSave =true;
        Set<ConstraintViolation<ConsoleDto>> constraintViolations = Validation.buildDefaultValidatorFactory().getValidator().validate(console);
        if (!constraintViolations.isEmpty()){
            consoleSave =false;
            App.APPLOGGER.log(Level.SEVERE, "echec de validation");
        }else {
            try {
                consoleService.saveConsole(console);

                List<ConsoleDto> consoles = consoleService.getAllOrderByDate();
                model.addAttribute(modelAttribListConsole, consoles);
            } catch (JeuException ex) {
                consoleSave = false;
                App.APPLOGGER.log(Level.SEVERE, ex.getMessage());
            }
        }
        if(consoleSave)
            console = new ConsoleDto();
        model.addAttribute("editConsole",console);
        model.addAttribute("consoleSave",consoleSave);
        return "console/create_console";
    }

    @GetMapping({"/list_console"})
    public String list(Model model) {
        try {
            List<ConsoleDto> consoles = consoleService.getAllOrderByDate();
            model.addAttribute(modelAttribListConsole, consoles);
        }catch (Exception ex){
            App.APPLOGGER.log(Level.SEVERE,ex.getMessage());
        }


        return "console/list_consoles";
    }

    @GetMapping({"/find_console"})
    public String find(Model model,@RequestParam (value="console", required=false)String consoleName) {
        ConsoleDto console = null;
        boolean find = true;
        if(consoleName!=null && consoleName.length()!=0){
            try {
                console = consoleService.getConsoleByName(consoleName);
            }catch (Exception ex){
                App.APPLOGGER.log(Level.SEVERE,ex.getMessage());
            }
            if(console==null) {
                find = false;
            }
            model.addAttribute("find",find);
        }
        model.addAttribute("select",console);

        return "console/search_console";
    }

}
