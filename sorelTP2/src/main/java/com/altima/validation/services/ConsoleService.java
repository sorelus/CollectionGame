package com.altima.validation.services;

import com.altima.validation.dtos.entities.ConsoleDto;

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
    void saveConsole(ConsoleDto console);


    /**
     * get all console order by create date
     * @return sort consoles
     */
    List<ConsoleDto> getAllOrderByDate ();

    /**
     * get an specific console identify by name
     * @param name name of specific console that we want to get
     * @return console information return by DB
     */
    ConsoleDto getConsoleByName(String name);

    /**
     * get an specific console identify by id
     * @param id id of specific console that we want to get
     * @return console information return by DB
     */
    ConsoleDto getConsoleId(int id);


    /**
     * save list of console
     * @param consoles list of console to save
     */
    void saveAllConsoles(List<ConsoleDto> consoles);
}
