package com.altima.validation.utilis;

import com.altima.validation.App;
import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.time.LocalTime;
import java.util.ArrayList;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import java.net.MalformedURLException;
import java.util.logging.Level;

@Service
public class UploadManager {



    @Autowired
    PasswordEncoder encoder; // Use to generate special string to save image

    private  String folder = "upload/";
    public String saveFile(MultipartFile file,String gameName) throws IOException{
        String specialName =null;
        String extension = FilenameUtils.getExtension(file.getOriginalFilename());
        if(extension!=null){


        ArrayList<String> validExtension = new ArrayList<>();
        validExtension.add("jpg");
        validExtension.add("jpeg");
        validExtension.add("png");
        if(!validExtension.contains(extension)){
             throw new IOException("bad extension file");
        }
        // create special unique name to save file
          specialName = encoder.encode(gameName+file.getOriginalFilename().replace(extension,"")+ LocalTime.now() );
            // Get the file and save it
            byte[] bytes = file.getBytes();
            specialName =  specialName+"."+extension;
            Path path = Paths.get(folder + specialName);
            Files.write(path, bytes);
        }else{
            throw new IOException("extension not exist");
        }
            return specialName;
    }

    public void deleteFile(String name) {
        try{
            File file = new File(folder+name);
           Files.delete(file.toPath());
        }catch ( IOException ex){
            App.APPLOGGER.log(Level.SEVERE,"Error with delete file "+ex);
        }
    }

    public Resource loadFileAsResource(String specialName) throws MalformedURLException {
        Resource resource =null;
            Path filePath =  Paths.get(folder + specialName).normalize();
            resource = new UrlResource(filePath.toUri());

        return resource;
    }
}
