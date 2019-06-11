package com.altima.validation;

import com.altima.validation.entities.Console;
import com.altima.validation.entities.JeuVideo;
import com.altima.validation.services.ConsoleService;
import com.altima.validation.services.JeuVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
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
public class App  implements CommandLineRunner
{
    public static final  Logger LOGGER = Logger.getLogger(App.class.getName());
    public static void main( String[] args )
    {
        SpringApplication.run(App.class, args);
    }

    @Resource(name = "c1")
    Console nintendo;

    @Resource(name = "c2")
    Console ps2;

    @Resource(name = "c3")
    Console xbox;


    @Resource(name = "j1")
    JeuVideo j1;

    @Resource(name = "j2")
    JeuVideo j2;

    @Resource(name = "j3")
    JeuVideo j3;

    @Resource(name = "j4")
    JeuVideo j4;

    @Resource(name = "j5")
    JeuVideo j5;

    @Resource(name = "j6")
    JeuVideo j6;

    @Resource(name = "j7")
    JeuVideo j7;


    // ours services to save and get data to DB

    @Autowired
    ConsoleService consoleService;

    @Autowired
    JeuVideoService jeuVideoService;

    @Override
    public void run(String... args) throws Exception {
        List<Console> consoles = new ArrayList();
        consoles.add(nintendo);
        consoles.add(ps2);
        consoles.add(xbox);

        List<JeuVideo> jeuxVideos = new ArrayList();
        jeuxVideos.add(j1);
        jeuxVideos.add(j2);
        jeuxVideos.add(j3);
        jeuxVideos.add(j4);
        jeuxVideos.add(j5);
        jeuxVideos.add(j6);
        jeuxVideos.add(j7);

        // save consoles
        try {
            consoleService.saveAllConsoles(consoles);
        }catch (Exception ex){
            LOGGER.log(Level.SEVERE,ex.getMessage());
        }

        //save Jeux Videos
        try {
            jeuVideoService.saveAllJeux(jeuxVideos);
        }catch (Exception ex){
            LOGGER.log(Level.SEVERE,ex.getMessage());
        }

        boolean terminer = false;
        while(!terminer) {
            System.out.println("==========================");
            System.out.println("1- Lister les consoles par date de creation");
            System.out.println("2- Rechercher une console avec son nom");
            System.out.println("3- Lister les jeux par console ensuite par date de creation");
            System.out.println("4- Rechercher une jeux avec son nom");
            System.out.println("5- Quitter");
            System.out.println("==========================");
            System.out.print("faites votre choix : ");
            int select = select(1, 5);
            Scanner sc = new Scanner(System.in);
            String name = null;
            switch (select) {
                case 1:
                    /**
                     * Get all console order by create date.
                     */
                    System.out.println("-----------------------");
                    consoles =  consoleService.getAllOrderByDate();
                    consoles.forEach(System.out::println);
                    System.out.println("-----------------------");
                    break;
                case 2:
                    /**
                     * Get console by name
                     */
                    System.out.println("-----------------------");
                    System.out.print("Entrez le nom de la console à chercher ");
                    name = sc.nextLine();
                    Console console = consoleService.getConsoleByName(name);
                    if(console!=null) {
                        System.out.println(console);
                    }
                    else{
                        System.out.println("Aucune console de ce nom n'existe dans le DB");
                    }

                    System.out.println("-----------------------");
                    break;
                case 3:
                    /**
                     * Get all jeuxVideos order by consoles and create date.
                     */
                    System.out.println("-----------------------");
                    jeuxVideos =  jeuVideoService.getAllOrderByConsoleThenByDate();
                    jeuxVideos.forEach(System.out::println);
                    System.out.println("-----------------------");
                    break;
                case 4:
                    /**
                     * Get jeuxVideos by name
                     */
                    System.out.println("-----------------------");
                    System.out.print("Entrez le nom de la console à chercher ");
                    name = sc.nextLine();
                    JeuVideo jeuVideo =jeuVideoService.getJeuByName(name);
                    if(jeuVideo!=null) {
                        System.out.println(jeuVideo);
                    }
                    else{
                        System.out.println("Aucune jeuVideo de ce nom n'existe dans le DB");
                    }
                    break;
                case 5:
                    terminer = true;
                    break;
                default:
                    break;
            }
        }



    }


    private static int select(int min, int max){
        boolean correctValue = false;
        int select = 0;
        Scanner sc = new Scanner(System.in);
        while (!correctValue) {
            String choice = sc.nextLine();
            try {
                select = Integer.parseInt(choice);
                if (select >= min && select <= max) {
                    correctValue = true;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException ex) {
                System.out.print("SVP selectionnez un numero valide (" + min + "-" + max + ")");
            }
        }
        return select;
    }
}
