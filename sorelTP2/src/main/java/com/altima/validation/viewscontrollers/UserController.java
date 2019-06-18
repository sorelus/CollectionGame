package com.altima.validation.viewscontrollers;

import com.altima.validation.App;
import com.altima.validation.dtos.entities.JeuVideoDto;
import com.altima.validation.dtos.entities.UserDto;
import com.altima.validation.services.JeuVideoService;
import com.altima.validation.services.UserService;
import com.altima.validation.utilis.HashPassword;
import com.altima.validation.utilis.JeuException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;
import javax.validation.*;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;

@Controller
public class UserController{

    @Autowired
    UserService userService;

    @Autowired
    JeuVideoService jeuVideoService;

    String listUsersValue ="users";

    @GetMapping({"/create_user"})
    public String create(Model model, @RequestParam(value="login", required=false)String login){
      chargementDeListJeux(model,login);
      return "user/create_user";
    }

    @PostMapping({"/create_user"})
    public String update(  @ModelAttribute(value="editUser") UserDto user, Model model){
        // check if contraint is violate
        boolean error =false;
        Set<ConstraintViolation<UserDto>> constraintViolations = Validation.buildDefaultValidatorFactory().getValidator().validate(user);
        UserDto userDto = new UserDto();
        if (!constraintViolations.isEmpty()){
            error =true;
            App.APPLOGGER.log(Level.SEVERE, "echec de validation");
        }
        try {
            // hash password before save
            user.setPass(HashPassword.getHash(user.getPass()));
            userService.saveUser(user);
            List<UserDto> users = userService.getAllUsers();
            model.addAttribute(listUsersValue,users);
        }catch (JeuException| NoSuchAlgorithmException ex){
            error =true;
            App.APPLOGGER.log(Level.SEVERE,ex.getMessage());
        }
        model.addAttribute("errorJeu",error);
        model.addAttribute("editUser",userDto);
        return "user/create_user";
    }

    @GetMapping({"/list_user"})
    public String list(Model model){
        List<UserDto> users =null;
        try {
            users = userService.getAllUsers();
        }catch (JeuException ex){
            App.APPLOGGER.log(Level.SEVERE,ex.getMessage());
        }
        model.addAttribute(listUsersValue,users);
        return "user/list_users";
    }

    @GetMapping({"/list_jeux_user"})
    public String listJeux(Model model, @RequestParam(value="login", required=false)String login){
      chargementDeListJeux(model, login);
       try {
           List<JeuVideoDto> jeux = jeuVideoService.getAllOrderByConsoleThenByDate();
           model.addAttribute("jeux",jeux);
       }catch (Exception ex){
           App.APPLOGGER.log(Level.SEVERE,ex.getMessage());
       }

        return "user/list_jeux_user";
    }

    @PostMapping({"/list_jeux_user"})
    public ModelAndView  listJeuxPost(Model model, RedirectAttributes attributes, @RequestParam(value="jeu")int jeu, @RequestParam(value="login")String login){
        JeuVideoDto jeuVideoDto = null;
        UserDto userDto = new UserDto();
        try {
            if(login!=null && login.length()!=0){
                userDto = userService.getByLogin(login);
                if(userDto!=null){
                    jeuVideoDto = jeuVideoService.getJeuById(jeu);
                    userDto.addToCollection(jeuVideoDto);

                    userService.saveUser(userDto);
                }
            }
        }catch (JeuException ex){
            App.APPLOGGER.log(Level.SEVERE,ex.getMessage());
        }
        attributes.addAttribute("login", login);
        return new ModelAndView("redirect:/list_jeux_user");
    }

    @PostMapping({"/delete_jeu"})
    public RedirectView  deleteJeu(Model model, RedirectAttributes attributes, @RequestParam(value="jeu")int jeu, @RequestParam(value="login")String login){
        UserDto userDto = null;
        try {
            if(login!=null && login.length()!=0){
                userDto = userService.getByLogin(login);
                userDto.deleteFromColection(jeu);
                userService.saveUser(userDto);
            }
        }catch (JeuException ex){
            App.APPLOGGER.log(Level.SEVERE,ex.getMessage());
        }
        attributes.addAttribute("login", login);
        return new RedirectView("/list_jeux_user");
    }

    private Model chargementDeListJeux(Model model,String login){
        UserDto userDto = null;
        boolean error =false;
        try {
            List<UserDto> users = userService.getAllUsers();
            if(users!=null) {
                model.addAttribute(listUsersValue, users);
            }
            if(login!=null && login.length()!=0){
                userDto = userService.getByLogin(login);
            }

        }catch (JeuException ex){
            error =true;
            model.addAttribute("errorJeu",error);
        }
        if(userDto!=null) {
            userDto.setPass("");
        }else{
            userDto = new UserDto();
        }
        model.addAttribute("editUser",userDto);
        return model;
    }
}