package com.altima.validation;

import com.altima.validation.entities.Console;
import com.altima.validation.entities.JeuVideo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class  use to start app
 * We use spring boot version 2.0 (Spring Framework 5)
 */

@SpringBootApplication
public class App  implements CommandLineRunner
{
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        System.out.println("TP 2 version 0");

    }
}
