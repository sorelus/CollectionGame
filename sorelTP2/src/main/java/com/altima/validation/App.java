package com.altima.validation;

import com.altima.validation.entities.Console;
import com.altima.validation.entities.JeuVideo;
import com.altima.validation.services.ConsoleService;
import com.altima.validation.services.JeuVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Main class  use to start app
 * We use spring boot version 2.0 (Spring Framework 5)
 * @author sorelus Mkounga
 */

@SpringBootApplication
public class App  extends SpringBootServletInitializer
{
    public static final  Logger LOGGER = Logger.getLogger(App.class.getName());

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(App.class);
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
