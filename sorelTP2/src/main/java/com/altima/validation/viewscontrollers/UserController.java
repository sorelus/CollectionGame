package com.altima.validation.viewscontrollers;

import com.altima.validation.App;
import com.altima.validation.dtos.entities.JeuVideoDto;
import com.altima.validation.dtos.entities.UserDto;
import com.altima.validation.dtos.entities.UserJeuDto;
import com.altima.validation.services.JeuVideoService;
import com.altima.validation.services.UserService;
import com.altima.validation.utilis.HashPassword;
import com.altima.validation.utilis.JeuException;
import com.altima.validation.utilis.SimpleEncode;
import com.altima.validation.utilis.UrlsControllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private SimpleEncode simpleEncode;

    @Autowired
    private JeuVideoService jeuVideoService;

    private String modelAttribListUsersValue = "users";
    private String modelAttribErrorJeu = "errorJeu";
    private String modelAttribEditUser = "editUser";

    @PreAuthorize("hasAuthority('admin')")
    @GetMapping({UrlsControllers.CREATE_USER_URL})
    public String create(Model model, @RequestParam(value = "login", required = false) String login) {
        return createInter(model, login, UrlsControllers.CREATE_USER_URL);
    }

    @PreAuthorize("hasAuthority('admin')")
    @PostMapping({UrlsControllers.CREATE_USER_URL})
    public String update(@ModelAttribute(value = "editUser") UserDto user, Model model) {
        return updateInter(user, model, UrlsControllers.CREATE_USER_URL);
    }

    @PreAuthorize("hasAuthority('admin')")
    @GetMapping({UrlsControllers.LIST_USER_URL})
    public String list(Model model) {
        List<UserDto> users = null;
        try {
            users = userService.getAllUsers();
        } catch (JeuException ex) {
            App.APPLOGGER.log(Level.SEVERE, ex.getMessage());
        }
        model.addAttribute(modelAttribListUsersValue, users);
        return "user/list_users";
    }

    @PreAuthorize("hasAuthority('admin')")
    @GetMapping({UrlsControllers.LINK_USER_URL})
    public String listJeux(Model model, @RequestParam(value = "login", required = false) String login) {
        return showListJeux(model, login, UrlsControllers.LINK_USER_URL, UrlsControllers.DELETE_USER_URL);

    }

    @PreAuthorize("hasAuthority('admin')")
    @PostMapping({UrlsControllers.LINK_USER_URL})
    public RedirectView listJeuxPost(RedirectAttributes attributes, @RequestParam(value = "jeu") int jeu, @RequestParam(value = "login") String login) {
        return showListJeuxPost(attributes, jeu, login, "/list_jeux_user");
    }

    @PreAuthorize("hasAuthority('admin')")
    @PostMapping({UrlsControllers.DELETE_USER_URL})
    public RedirectView deleteJeu(RedirectAttributes attributes, @RequestParam(value = "jeu") int jeu, @RequestParam(value = "login") String login) {

        return showDeleteJeu(attributes, jeu, login, UrlsControllers.LINK_USER_URL);
    }


    @PostMapping({UrlsControllers.SIMPLE_CREATE_USER_URL})
    public String registrationUpdate(@ModelAttribute(value = "editUser") UserDto user, Model model) {
        String ret = registerUpdate(user, model);
        Map<String, Object> modelMap = model.asMap();
        Object bool = modelMap.get(modelAttribErrorJeu);

        if (bool == null || !(Boolean) bool)
            ret = "confirmation";

        return ret;
    }

    @GetMapping({UrlsControllers.SIMPLE_CREATE_USER_URL})
    public String registration(Model model) {
        return createInter(model, "", UrlsControllers.SIMPLE_CREATE_USER_URL);
    }

    @PreAuthorize("hasAuthority('simple')")
    @PostMapping({UrlsControllers.SIMPLE_UPDATE_PROFILE})
    public String registerUpdate(@ModelAttribute(value = "editUser") UserDto user, Model model) {

        String ret = updateInter(user, model, UrlsControllers.SIMPLE_CREATE_USER_URL);
        user.setPass("");
        model.addAttribute(modelAttribEditUser, user);
        return ret;
    }

    @PreAuthorize("hasAuthority('simple')")
    @GetMapping({UrlsControllers.SIMPLE_UPDATE_PROFILE})
    public String updateProfile(Model model, Principal principal) {
        String login = principal.getName();
        return createInter(model, login, UrlsControllers.SIMPLE_UPDATE_PROFILE);
    }

    @PreAuthorize("hasAuthority('simple')")
    @GetMapping({UrlsControllers.SIMPLE_LIST_GAME_URL})
    public String mesJeux(Model model, Principal principal) {
        String login = principal.getName();
        return showListJeux(model, login, UrlsControllers.SIMPLE_LIST_GAME_URL, UrlsControllers.SIMPLE_DELETE_USER_URL);
    }

    @PreAuthorize("hasAuthority('simple')")
    @PostMapping({UrlsControllers.SIMPLE_LIST_GAME_URL})
    public RedirectView mesJeuxPost(Principal principal, RedirectAttributes attributes, @RequestParam(value = "jeu") int jeu) {
        String login = principal.getName();
        return showListJeuxPost(attributes, jeu, login, UrlsControllers.SIMPLE_LIST_GAME_URL);
    }

    @PreAuthorize("hasAuthority('simple')")
    @PostMapping({UrlsControllers.SIMPLE_DELETE_USER_URL})
    public RedirectView deleteMesJeuxPost(Principal principal, Model model, RedirectAttributes attributes, @RequestParam(value = "jeu") int jeu) {
        String login = principal.getName();
        return showDeleteJeu(attributes, jeu, login, UrlsControllers.SIMPLE_LIST_GAME_URL);
    }


    public String createInter(Model model, String login, String action) {
        chargementDeListJeux(model, login);
        model.addAttribute("action", action);
        return "user/create_user";
    }

    public String updateInter(UserDto user, Model model, String action) {
        // check if contraint is violate
        boolean error = false;
        Set<ConstraintViolation<UserDto>> constraintViolations = Validation.buildDefaultValidatorFactory().getValidator().validate(user);
        UserDto userDto = new UserDto();
        if (user != null) {
            if (user.getRoles().contains("1")) {
                user.getRoles().remove("1");
                user.addRole("admin");
                user.addRole("simple");
            }
            user.getRoles().remove("2");
            user.addRole("simple");

        }
        if (!constraintViolations.isEmpty()) {
            error = true;
            App.APPLOGGER.log(Level.SEVERE, "echec de validation");
        }
        try {
            // hash password before save
            if (user != null) {
                user.setPass(HashPassword.getHash(user.getPass()));
                if (user.getId() != null) {
                    UserDto userTemp = userService.getById(user.getId());

                    if (userTemp != null) {
                        user.setCollection(userTemp.getCollection());
                    }
                }

                if (!error) {
                    userService.saveUser(user);
                }
            }
            List<UserDto> users = userService.getAllUsers();
            model.addAttribute(modelAttribListUsersValue, users);
        } catch (JeuException | NoSuchAlgorithmException ex) {
            error = true;
            App.APPLOGGER.log(Level.SEVERE, ex.getMessage());
        }
        model.addAttribute(modelAttribErrorJeu, error);
        model.addAttribute(modelAttribEditUser, userDto);
        model.addAttribute("action", action);
        return "user/create_user";
    }


    public String showListJeux(Model model, String login, String action1, String action2) {
        chargementDeListJeux(model, login);
        try {
            List<JeuVideoDto> jeux = jeuVideoService.getAllOrderByConsoleThenByDate();
            model.addAttribute("jeux", jeux);

        } catch (Exception ex) {
            App.APPLOGGER.log(Level.SEVERE, ex.getMessage());
        }
        model.addAttribute("PostAction1", action1);
        model.addAttribute("PostAction2", action2);
        model.addAttribute("userJeu", new UserJeuDto());
        return "user/list_jeux_user";
    }

    public RedirectView showListJeuxPost(RedirectAttributes attributes, int jeu, String login, String action) {
        JeuVideoDto jeuVideoDto = null;
        UserDto userDto = new UserDto();
        try {
            if (login != null && login.length() != 0) {
                userDto = userService.getByLogin(login);
                if (userDto != null) {
                    jeuVideoDto = jeuVideoService.getJeuById(jeu);
                    userDto.addToCollection(jeuVideoDto);

                    userService.saveUser(userDto);
                }
            }
        } catch (JeuException ex) {
            App.APPLOGGER.log(Level.SEVERE, ex.getMessage());
        }
        attributes.addAttribute("login", login);
        return  new RedirectView(action);
    }


    public RedirectView showDeleteJeu(RedirectAttributes attributes, int jeu, String login, String action) {
        UserDto userDto = null;
        try {
            if (login != null && login.length() != 0) {
                userDto = userService.getByLogin(login);
                userDto.deleteFromColection(jeu);
                userService.saveUser(userDto);
            }
        } catch (JeuException ex) {
            App.APPLOGGER.log(Level.SEVERE, ex.getMessage());
        }
        attributes.addAttribute("login", login);
        return new RedirectView(action);
    }

    public Model chargementDeListJeux(Model model, String login) {
        UserDto userDto = null;
        boolean error = false;
        try {
            List<UserDto> users = userService.getAllUsers();
            if (users != null) {
                model.addAttribute(modelAttribListUsersValue, users);
            }
            if (login != null && login.length() != 0) {
                userDto = userService.getByLogin(login);
            }

        } catch (JeuException ex) {
            error = true;
            model.addAttribute(modelAttribErrorJeu, error);
        }
        if (userDto != null) {
            //add information for public url
            model.addAttribute("userIdEncode", simpleEncode.encode(userDto.getId().toString()));
            userDto.setPass("");
        } else {
            userDto = new UserDto();
        }
        model.addAttribute(modelAttribEditUser, userDto);
        return model;
    }

}