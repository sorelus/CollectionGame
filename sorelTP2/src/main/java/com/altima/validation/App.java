package com.altima.validation;

import com.altima.validation.entities.Console;
import com.altima.validation.entities.JeuVideo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Main class  use to start app
 * We use spring boot version 2.0 (Spring Framework 5)
 * @author sorelus Mkounga
 */

@SpringBootApplication
public class App  implements CommandLineRunner
{
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


    @Override
    public void run(String... args) throws Exception {
        List<Console> consoles = new ArrayList();
        consoles.add(nintendo);
        consoles.add(ps2);
        consoles.add(xbox);
        /*
         sort console by DateDeSortie
         */

        Comparator consoleComparatorByCreateDate = Comparator.comparing(Console::getDateDeSortie);
        consoles.sort(consoleComparatorByCreateDate);
        System.out.println("Lister les consoles par date de sortie (ascendant)");
        consoles.forEach(System.out::println);
        System.out.println("==============================================");

         /*
         sort console by DateDeSortie reverse
         */
        consoles.sort(consoleComparatorByCreateDate.reversed());
        System.out.println("Lister les consoles par date de sortie (descendante)");
        consoles.forEach(System.out::println);
        System.out.println("==========================================");

        List<JeuVideo> jeuxVideos = new ArrayList();
        jeuxVideos.add(j1);
        jeuxVideos.add(j2);
        jeuxVideos.add(j3);
        jeuxVideos.add(j4);
        jeuxVideos.add(j5);
        jeuxVideos.add(j6);
        jeuxVideos.add(j7);

        /*
            here we compare the list by console (base on console create date)
            then I compare by date of creation of the game
         */
        Comparator gameComparatorByConsoleThemByDate =  Comparator.comparing(JeuVideo::getConsole,consoleComparatorByCreateDate)
                .thenComparing(Comparator.comparing(JeuVideo::getDateDeSortie));

        jeuxVideos.sort(gameComparatorByConsoleThemByDate);

        System.out.println("Lister des Jeux par console puis par date de sortie (ascendante)");
        jeuxVideos.forEach(System.out::println);
        System.out.println("======================================");

        jeuxVideos.sort(gameComparatorByConsoleThemByDate.reversed());

        System.out.println("Lister des Jeux par console puis par date de sortie (descendante)");
        jeuxVideos.forEach(System.out::println);
        System.out.println("======================================");

    }
}
