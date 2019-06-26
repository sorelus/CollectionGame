package com.altima.validation.viewscontrollers;

import com.altima.validation.App;
import com.altima.validation.dtos.entities.ConsoleDto;
import com.altima.validation.services.ConsoleService;
import com.altima.validation.utilis.JeuException;
import com.altima.validation.utilis.UrlsControllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;


/**
 * ConsoleController class use for all controller that edit console
 *
 * @author sorelus Mkounga
 */

@PreAuthorize("hasAuthority('admin')") // To use method of this controllerm user must be admin
@Controller
public class ConsoleController {

    @Autowired
    private ConsoleService consoleService;


    private String modelAttribListConsole = "consoles";

    /**
     * Use for show  create console page
     * @param model use for exchange data with jsp page
     * @param consoleName name of console, want it is null (not exist), show only create page else show edit page
     * @return jsp console create page
     */
    @GetMapping({UrlsControllers.CREATE_CONSOLE_URL})
    public String create(Model model, @RequestParam(value = "console", required = false) String consoleName) {
        ConsoleDto console = null;
        try {
            List<ConsoleDto> consoles = consoleService.getAllOrderByDate();
            model.addAttribute(modelAttribListConsole, consoles);

            if (consoleName != null && consoleName.length() != 0) {
                console = consoleService.getConsoleByName(consoleName);
            }
        } catch (JeuException ex) {
            App.APPLOGGER.log(Level.SEVERE, ex.getMessage());
        }
        if (console == null)
            console = new ConsoleDto();
        model.addAttribute("editConsole", console);

        return "console/create_console";
    }

    /**
     * Use for show  save console info (create or edit)
     * @param model use for exchange data with jsp page
     * @param console console information to save
     * @return jsp console create page
     */
    @PostMapping({UrlsControllers.CREATE_CONSOLE_URL})
    public String edit(@ModelAttribute("editConsole") ConsoleDto console, Model model) {
        boolean consoleSave = true;
        Set<ConstraintViolation<ConsoleDto>> constraintViolations = Validation.buildDefaultValidatorFactory().getValidator().validate(console);
        if (!constraintViolations.isEmpty()) {
            consoleSave = false;
            App.APPLOGGER.log(Level.SEVERE, "echec de validation");
        } else {
            try {
                consoleService.saveConsole(console);

                List<ConsoleDto> consoles = consoleService.getAllOrderByDate();
                model.addAttribute(modelAttribListConsole, consoles);
            } catch (JeuException ex) {
                consoleSave = false;
                App.APPLOGGER.log(Level.SEVERE, ex.getMessage());
            }
        }
        if (consoleSave)
            console = new ConsoleDto();
        model.addAttribute("editConsole", console);
        model.addAttribute("consoleSave", consoleSave);
        return "console/create_console";
    }

    /**
     * Use for show  list page
     * @param model use for exchange data with jsp page
     * @return jsp console list page
     */
    @GetMapping({UrlsControllers.LIST_CONSOLE_URL})
    public String list(Model model) {
        try {
            List<ConsoleDto> consoles = consoleService.getAllOrderByDate();
            model.addAttribute(modelAttribListConsole, consoles);
        } catch (Exception ex) {
            App.APPLOGGER.log(Level.SEVERE, ex.getMessage());
        }


        return "console/list_consoles";
    }

    /**
     * Use to show  find page
     * @param model
     * @param consoleName console name we want to find
     * @return jsp console find page
     */
    @GetMapping({UrlsControllers.FIND_CONSOLE_URL})
    public String find(Model model, @RequestParam(value = "console", required = false) String consoleName) {
        ConsoleDto console = null;
        boolean find = true;
        if (consoleName != null && consoleName.length() != 0) {
            try {
                console = consoleService.getConsoleByName(consoleName);
            } catch (Exception ex) {
                App.APPLOGGER.log(Level.SEVERE, ex.getMessage());
            }
            if (console == null) {
                find = false;
            }
            model.addAttribute("find", find);
        }
        model.addAttribute("select", console);

        return "console/search_console";
    }

}
