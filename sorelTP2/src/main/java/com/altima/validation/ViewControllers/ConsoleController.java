package com.altima.validation.ViewControllers;


import com.altima.validation.App;
import com.altima.validation.entities.Console;
import com.altima.validation.services.ConsoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

@Controller
public class ConsoleController {
    @Autowired
    ConsoleService consoleService;

    @GetMapping({"/create_console"})
    public String create(Model model,@RequestParam (value="console", required=false)String consoleName) {
        List<Console> consoles = consoleService.getAllOrderByDate();
        model.addAttribute("consoles", consoles);
        Console console = null;
        if(consoleName!=null && consoleName.length()!=0){
            console = consoleService.getConsoleByName(consoleName);
        }
        if(console==null)
            console =new Console();
        model.addAttribute("editConsole",console);
        return "console/create_console";
    }

    @PostMapping({"/create_console"})
    public String edit(@Valid @ModelAttribute("editConsole")Console console, Model model) {
        boolean consoleSave =true;
        try{
            consoleService.saveConsole(console);
        }catch (Exception ex){
            consoleSave =false;
            App.LOGGER.log(Level.SEVERE,"Probleme avec l enregistrement : "+ ex.getMessage());
        }
        List<Console> consoles = consoleService.getAllOrderByDate();
        model.addAttribute("consoles", consoles);
        if(consoleSave)
            console = new Console();
        model.addAttribute("editConsole",console);
        model.addAttribute("consoleSave",consoleSave);
        return "console/create_console";
    }

    @GetMapping({"/list_console"})
    public String list(Model model) {
        List<Console> consoles = consoleService.getAllOrderByDate();
        model.addAttribute("consoles", consoles);
        return "console/list_consoles";
    }

    @GetMapping({"/find_console"})
    public String find(Model model,@RequestParam (value="console", required=false)String consoleName) {
        Console console = null;
        if(consoleName!=null && consoleName.length()!=0){
            console = consoleService.getConsoleByName(consoleName);
            if(console!=null){
                model.addAttribute("find",true);
            }else
                model.addAttribute("find",false);
        }
        model.addAttribute("select",console);

        return "console/search_console";
    }

}
