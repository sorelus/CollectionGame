package com.altima.validation.viewscontrollers;


import com.altima.validation.App;
import com.altima.validation.dtos.entities.UserDto;
import com.altima.validation.services.UserService;
import com.altima.validation.utilis.SimpleEncode;
import com.altima.validation.utilis.UploadManager;
import com.altima.validation.utilis.UrlsControllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.logging.Level;

@Controller
@RequestMapping(value = "public/")
public class PublicController {
    @Autowired
    private UploadManager uploadManager;

    @Autowired
    private UserService userService;

    @Autowired
    private SimpleEncode simpleEncode;

    @RequestMapping(value = UrlsControllers.DOWNLOAD_FILE)
    public ResponseEntity<Resource> downloadFile(@PathVariable String imageId, HttpServletRequest request) {
        ResponseEntity<Resource> resourceEntity =null;
        String type = null;
        try {
            // Load file
            Resource resource = uploadManager.loadFileAsResource(imageId);

            // Check contentType from ressource
            type = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());

            // if we didn't detect type, we define by default
            if(type == null) {
                type = "application/octet-stream";
            }
            resourceEntity =  ResponseEntity.ok()
                    .contentType(MediaType.parseMediaType(type))
                    .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + resource.getFilename() + "\"")
                    .body(resource);
        } catch (IOException ex) {
            App.APPLOGGER.log(Level.SEVERE, ex.getMessage());
        }
        return resourceEntity;
    }

    @GetMapping({"/{userId}"})
    public String myPublicGame(Model model, @PathVariable String userId) {

        String link="error";
        int user=-1;
        try{
            user = Integer.parseInt(simpleEncode.decode(userId));
            UserDto userInfo = userService.getById(user);
            model.addAttribute("user", userInfo);
            link = "show";
        }catch (Exception ex){
            App.APPLOGGER.log(Level.SEVERE, ex.getMessage());
        }

        return link;
    }

}


