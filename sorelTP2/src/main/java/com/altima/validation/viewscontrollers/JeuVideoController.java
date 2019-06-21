package com.altima.validation.viewscontrollers;


import com.altima.validation.App;
import com.altima.validation.dtos.entities.ConsoleDto;
import com.altima.validation.dtos.entities.JeuVideoDto;
import com.altima.validation.services.ConsoleService;
import com.altima.validation.services.JeuVideoService;
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


@PreAuthorize("hasAuthority('admin')")
@Controller
public class JeuVideoController {

    @Autowired
    private JeuVideoService jeuVideoService;

    @Autowired
    private ConsoleService consoleService;

    @GetMapping({UrlsControllers.createJeuURL})
    public String create(Model model, @RequestParam(value = "jeu", required = false) String jeuName) {
        JeuVideoDto jeu = null;
        try {
            List<JeuVideoDto> jeux = jeuVideoService.getAllOrderByConsoleThenByDate();
            model.addAttribute("jeux", jeux);
            if (jeuName != null && jeuName.length() != 0) {
                jeu = jeuVideoService.getJeuByName(jeuName);
            }
        } catch (Exception ex) {
            App.APPLOGGER.log(Level.SEVERE, ex.getMessage());
        }


        if (jeu == null)
            jeu = new JeuVideoDto();
        model.addAttribute("editJeu", jeu);
        return "jeu/create_jeu";
    }


    @PostMapping({UrlsControllers.createJeuURL})
    public String edit(@ModelAttribute("editJeu") JeuVideoDto jeu, Model model) {
        ConsoleDto consoleDto = null;
        boolean jeuSave = true;
        Set<ConstraintViolation<JeuVideoDto>> constraintViolations = Validation.buildDefaultValidatorFactory().getValidator().validate(jeu);
        if (!constraintViolations.isEmpty()) {
            jeuSave = false;
            App.APPLOGGER.log(Level.SEVERE, "echec de validation");
        } else {
            try {
                // verification qnd get console information
                if (jeu.getId() != null) {
                    JeuVideoDto jeuTemp = jeuVideoService.getJeuById(jeu.getId());
                    if (jeuTemp != null)
                        consoleDto = jeuTemp.getConsole();
                }
                jeu.setConsole(consoleDto);
                jeuVideoService.saveJeu(jeu);

                List<JeuVideoDto> jeux = jeuVideoService.getAllOrderByConsoleThenByDate();
                model.addAttribute("jeux", jeux);


            } catch (Exception ex) {
                App.APPLOGGER.log(Level.SEVERE, ex.getMessage());
            }
        }
        model.addAttribute("jeuSave", jeuSave);
        if (jeuSave)
            jeu = new JeuVideoDto();
        model.addAttribute("editJeu", jeu);
        return "jeu/create_jeu";
    }

    @GetMapping({UrlsControllers.listJeuURL})
    public String list(Model model) {
        try {
            List<JeuVideoDto> jeux = jeuVideoService.getAllOrderByConsoleThenByDate();
            model.addAttribute("jeux", jeux);
        } catch (Exception ex) {
            App.APPLOGGER.log(Level.SEVERE, ex.getMessage());
        }

        return "jeu/list_jeux";
    }

    @GetMapping({UrlsControllers.linkJeuURL})
    public String lier(Model model) {
        try {
            List<JeuVideoDto> jeux = jeuVideoService.getAllOrderByConsoleThenByDate();
            List<ConsoleDto> consoles = consoleService.getAllOrderByDate();
            model.addAttribute("jeux", jeux);
            model.addAttribute("consoles", consoles);
        } catch (Exception ex) {
            App.APPLOGGER.log(Level.SEVERE, ex.getMessage());
        }

        return "jeu/lier_console";
    }

    @PostMapping({UrlsControllers.linkJeuURL})
    public String saveLiaison(Model model, @RequestParam(value = "jeu") int jeuId, @RequestParam(value = "console") int consoleId) {
        boolean jeuSave = false;
        try {
            JeuVideoDto jeu = jeuVideoService.getJeuById(jeuId);
            ConsoleDto console = consoleService.getConsoleId(consoleId);
            if (jeu != null && console != null) {
                jeu.setConsole(console);
                jeuVideoService.saveJeu(jeu);
                jeuSave = true;
            }
            List<JeuVideoDto> jeux = jeuVideoService.getAllOrderByConsoleThenByDate();
            List<ConsoleDto> consoles = consoleService.getAllOrderByDate();
            model.addAttribute("jeux", jeux);
            model.addAttribute("consoles", consoles);
            model.addAttribute("jeuSave", jeuSave);
        } catch (Exception ex) {
            App.APPLOGGER.log(Level.SEVERE, ex.getMessage());
        }
        return "jeu/lier_console";
    }

    @GetMapping({UrlsControllers.findJeuURL})
    public String find(Model model, @RequestParam(value = "jeu", required = false) String jeuName) {

        try {
            JeuVideoDto jeuVideo = null;
            boolean jeuSave = true;
            if (jeuName != null && jeuName.length() != 0) {
                jeuVideo = jeuVideoService.getJeuByName(jeuName);
                if (jeuVideo == null) {
                    jeuSave = false;
                }
                model.addAttribute("find", jeuSave);
            }
            model.addAttribute("select", jeuVideo);
        } catch (Exception ex) {
            App.APPLOGGER.log(Level.SEVERE, ex.getMessage());
        }
        return "jeu/search_jeu";
    }
}
