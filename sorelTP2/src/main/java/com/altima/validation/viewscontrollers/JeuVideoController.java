package com.altima.validation.viewscontrollers;


import com.altima.validation.App;
import com.altima.validation.dtos.entities.ConsoleDto;
import com.altima.validation.dtos.entities.JeuVideoDto;
import com.altima.validation.services.ConsoleService;
import com.altima.validation.services.JeuVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;
import java.util.logging.Level;

@Controller
public class JeuVideoController {
    @Autowired
    JeuVideoService jeuVideoService;

    @Autowired
    ConsoleService consoleService;

    @GetMapping({"/create_jeu"})
    public String create(Model model, @RequestParam(value="jeu", required=false)String jeuName) {
        List<JeuVideoDto> jeux = jeuVideoService.getAllOrderByConsoleThenByDate();
        model.addAttribute("jeux", jeux);
        JeuVideoDto jeu = null;
        if(jeuName!=null && jeuName.length()!=0){
            jeu = jeuVideoService.getJeuByName(jeuName);
        }
        if(jeu==null)
            jeu =new JeuVideoDto();
        model.addAttribute("editJeu",jeu);
        return "jeu/create_jeu";
    }


    @PostMapping({"/create_jeu"})
    public String edit(@Valid @ModelAttribute("editJeu")JeuVideoDto jeu, Model model) {
        ConsoleDto consoleDto =null;
        // verification qnd get console information
        if(jeu.getId()!=null) {
            JeuVideoDto jeuTemp = jeuVideoService.getJeuById(jeu.getId());
            if(jeuTemp!=null)
                consoleDto = jeuTemp.getConsole();
        }
        boolean jeuSave =true;
        try{
            jeu.setConsole(consoleDto);
            jeuVideoService.saveJeu(jeu);
        }catch (Exception ex){
            jeuSave =false;
            App.APPLOGGER.log(Level.SEVERE,"Probleme avec l'enregistrement : "+ ex.getMessage());
        }
        List<JeuVideoDto> jeux = jeuVideoService.getAllOrderByConsoleThenByDate();
        model.addAttribute("jeux", jeux);
        if(jeuSave)
            jeu = new JeuVideoDto();

        model.addAttribute("editJeu",jeu);
        model.addAttribute("jeuSave",jeuSave);
        return "jeu/create_jeu";
    }

    @GetMapping({"/list_jeu"})
    public String list(Model model) {
        List<JeuVideoDto> jeux = jeuVideoService.getAllOrderByConsoleThenByDate();
        model.addAttribute("jeux", jeux);
        return "jeu/list_jeux";
    }

    @GetMapping({"/lier_jeu"})
    public String lier(Model model) {
        List<JeuVideoDto> jeux = jeuVideoService.getAllOrderByConsoleThenByDate();
        List<ConsoleDto> consoles = consoleService.getAllOrderByDate();
        model.addAttribute("jeux", jeux);
        model.addAttribute("consoles", consoles);
        return "jeu/lier_console";
    }
    @PostMapping({"/lier_jeu"})
    public String saveLiaison(Model model,@RequestParam(value="jeu")int jeuId,@RequestParam(value="console")int consoleId) {
        boolean jeuSave =false;
        try {
            JeuVideoDto jeu = jeuVideoService.getJeuById(jeuId);
            ConsoleDto console = consoleService.getConsoleId(consoleId);
            if(jeu!=null && console!=null){
                jeu.setConsole(console);
                jeuVideoService.saveJeu(jeu);
                jeuSave =true;
            }
        }catch (Exception ex){
            App.APPLOGGER.log(Level.SEVERE,"Probleme avec la liaison des jeux et des consoles : "+ ex.getMessage());
        }

        List<JeuVideoDto> jeux = jeuVideoService.getAllOrderByConsoleThenByDate();
        List<ConsoleDto> consoles = consoleService.getAllOrderByDate();
        model.addAttribute("jeux", jeux);
        model.addAttribute("consoles", consoles);
        model.addAttribute("jeuSave",jeuSave);
        return "jeu/lier_console";
    }

    @GetMapping({"/find_jeu"})
    public String find(Model model,@RequestParam (value="jeu", required=false)String jeuName) {
        JeuVideoDto jeuVideo = null;
        boolean jeuSave =true;
        if(jeuName!=null && jeuName.length()!=0){
            jeuVideo = jeuVideoService.getJeuByName(jeuName);
            if(jeuVideo==null){
                jeuSave = false;
            }
            model.addAttribute("find",jeuSave);
        }
        model.addAttribute("select",jeuVideo);

        return "jeu/search_jeu";
    }
}
