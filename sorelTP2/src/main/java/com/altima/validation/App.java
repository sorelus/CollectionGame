package com.altima.validation;

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
        System.out.println("Bonjour Sorel");
    }
}
