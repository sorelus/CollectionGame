package com.altima.validation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.util.logging.Logger;

/**
 * Main class  use to start app
 * We use spring boot version 2.0 (Spring Framework 5)
 *
 * @author sorelus Mkounga
 */

@SpringBootApplication
public class App extends SpringBootServletInitializer {
    public static final Logger APPLOGGER = Logger.getLogger(App.class.getName());

    public static void main(String[] args) {

        SpringApplication.run(App.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(App.class);
    }

}
