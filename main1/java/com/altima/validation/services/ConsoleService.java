package com.altima.validation.services;

import com.altima.validation.dtos.entities.ConsoleDto;
import com.altima.validation.utilis.JeuException;

import java.util.List;

/**
 * ConsoleService interface
 *
 * @author sorelus Mkounga
 */
public interface ConsoleService {

    /**
     * save one console to DB
     *
     * @param console , console to save
     * @throws JeuException when an error occurs during treatment
     */
    void saveConsole(ConsoleDto console) throws JeuException;


    /**
     * get all console order by create date
     *
     * @return sort consoles
     * @throws JeuException when an error occurs during treatment
     */
    List<ConsoleDto> getAllOrderByDate() throws JeuException;

    /**
     * get an specific console identify by name
     *
     * @param name name of specific console that we want to get
     * @return console information return by DB
     * @throws JeuException when an error occurs during treatment
     */
    ConsoleDto getConsoleByName(String name) throws JeuException;

    /**
     * get an specific console identify by id
     *
     * @param id id of specific console that we want to get
     * @return console information return by DB
     * @throws JeuException when an error occurs during treatment
     */
    ConsoleDto getConsoleId(int id) throws JeuException;


    /**
     * save list of console
     *
     * @param consoles list of console to save
     * @throws JeuException when an error occurs during treatment
     */
    void saveAllConsoles(List<ConsoleDto> consoles) throws JeuException;
}
