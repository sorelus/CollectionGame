package com.altima.validation.viewscontrollers;


import com.altima.validation.App;
import com.altima.validation.dtos.entities.ConsoleDto;
import com.altima.validation.services.ConsoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.logging.Level;

@Controller
public class ConsoleController {
    @Autowired
    ConsoleService consoleService;

    String modelAttribListConsole = "consoles";
    @GetMapping({"/create_console"})
    public String create(Model model,@RequestParam (value="console", required=false)String consoleName) {
        List<ConsoleDto> consoles = consoleService.getAllOrderByDate();
        model.addAttribute(modelAttribListConsole, consoles);
        ConsoleDto console = null;
        if(consoleName!=null && consoleName.length()!=0){
            console = consoleService.getConsoleByName(consoleName);
        }
        if(console==null)
            console =new ConsoleDto();
        model.addAttribute("editConsole",console);
        return "console/create_console";
    }

    @PostMapping({"/create_console"})
    public String edit(@Valid @ModelAttribute("editConsole")ConsoleDto console, Model model) {
        boolean consoleSave =true;
        try{
            consoleService.saveConsole(console);
        }catch (Exception ex){
            consoleSave =false;
            App.APPLOGGER.log(Level.SEVERE,"Probleme avec l enregistrement : "+ ex.getMessage());
        }
        List<ConsoleDto> consoles = consoleService.getAllOrderByDate();
        model.addAttribute(modelAttribListConsole, consoles);
        if(consoleSave)
            console = new ConsoleDto();
        model.addAttribute("editConsole",console);
        model.addAttribute("consoleSave",consoleSave);
        return "console/create_console";
    }

    @GetMapping({"/list_console"})
    public String list(Model model) {
        List<ConsoleDto> consoles = consoleService.getAllOrderByDate();
        model.addAttribute(modelAttribListConsole, consoles);
        return "console/list_consoles";
    }

    @GetMapping({"/find_console"})
    public String find(Model model,@RequestParam (value="console", required=false)String consoleName) {
        ConsoleDto console = null;
        boolean find = true;
        if(consoleName!=null && consoleName.length()!=0){
            console = consoleService.getConsoleByName(consoleName);
            if(console==null) {
                find = false;
            }
            model.addAttribute("find",find);
        }
        model.addAttribute("select",console);

        return "console/search_console";
    }

}
