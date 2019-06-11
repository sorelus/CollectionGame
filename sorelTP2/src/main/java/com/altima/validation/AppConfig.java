package com.altima.validation;

import com.altima.validation.entities.Console;
import com.altima.validation.entities.JeuVideo;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * This class is our configuration class. We will declare our beans here.
 * @author sorelus Mkounga
 */
@Configuration
public class AppConfig {
    SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

    @Bean({"c1", "nintendo"})
    public Console newConsole1() throws ParseException {
        return new Console("Nintendo 64","Nintendo",format.parse ( "1996-06-23" ),64);
    }
    @Bean({"c2", "ps2"})
    public Console newConsole2()throws ParseException  {
        return new Console("PS2","Sony Computer Entertainment",format.parse ( "2000-11-20" ),128);
    }
    @Bean({"c3", "xbox"})
    public Console newConsole3()throws ParseException  {
        return new Console("Xbox 360","Microsoft",format.parse ( "2013-02-12" ),128);
    }


    @Bean({"j1"})
    public JeuVideo newJeuVideo1(@Qualifier("c2") final Console console)throws ParseException  {
        return new JeuVideo("GTA San Andreas","Rockstar Games",format.parse ( "2013-02-12" ),console);
    }
    @Bean({"j2"})
    public JeuVideo newJeuVideo2(@Qualifier("c2") final Console console)throws ParseException  {
        return new JeuVideo("Need for Speed: Most Wanted","Electronic Arts",format.parse ( "2005-11-11" ),console);
    }
    @Bean({"j3"})
    public JeuVideo newJeuVideo3(@Qualifier("c1") final Console console)throws ParseException  {
        return new JeuVideo("Mario Kart 64","Nintendo",format.parse ( "1996-12-14" ),console);
    }
    @Bean({"j4"})
    public JeuVideo newJeuVideo4(@Qualifier("c1") final Console console)throws ParseException  {
        return new JeuVideo("Resident Evil 2","Capcom",format.parse ( "1998-01-21" ),console);
    }
    @Bean({"j5"})
    public JeuVideo newJeuVideo5(@Qualifier("c3") final Console console)throws ParseException  {
        return new JeuVideo("FIFA 17","EA Vancouver",format.parse ( "2016-08-27" ),console);
    }
    @Bean({"j6"})
    public JeuVideo newJeuVideo6(@Qualifier("c3") final Console console)throws ParseException  {
        return new JeuVideo("Assassin's Creed","Ubisoft",format.parse ( "2007-08-13" ),console);
    }
    @Bean({"j7"})
    public JeuVideo newJeuVideo7(@Qualifier("c2") final Console console)throws ParseException  {
        return new JeuVideo("Silent Hill 2","Konami Computer Entertainment",format.parse ( "2001-08-24" ),console);
    }

}
