package com.altima.validation.services;

import com.altima.validation.entities.Console;

import java.util.List;
/**
 * ConsoleService interface
 * @author sorelus Mkounga
 */
public interface ConsoleService {

    /**
     * save one console to DB
     * @param console , console to save
     */
    void saveConsole(Console console);

    /**
     * get all console order by create date
     * @return sort consoles
     */
    List<Console> getAllOrderByDate ();

    /**
     * get an specific console identify by name
     * @param name name of specific console that we want to get
     * @return console information return by DB
     */
    Console getConsoleByName(String name);

    /**
     * save list of console
     * @param consoles list of console to save
     */
    void saveAllConsoles(List<Console> consoles);
}
