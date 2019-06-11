package com.altima.validation.services.impl;

import com.altima.validation.entities.Console;
import com.altima.validation.repositories.ConsoleRepository;
import com.altima.validation.services.ConsoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * ConsoleServiceImp class
 * @author sorelus Mkounga
 */
@Service
public class ConsoleServiceImp implements ConsoleService {

    @Autowired
    ConsoleRepository consoleRepository;


    /**
     * @see com.altima.validation.services.ConsoleService#saveConsole(Console)
     */
    @Override
    public void saveConsole(Console console) {
        consoleRepository.save(console);
    }
    /**
     * @see com.altima.validation.services.ConsoleService#getAllOrderByDate()
     */
    @Override
    public List<Console> getAllOrderByDate() {
        return consoleRepository.getByDateDeSortie();
    }
    /**
     * @see com.altima.validation.services.ConsoleService#getConsoleByName(String )
     */
    @Override
    public Console getConsoleByName(String name) {
        return consoleRepository.getByName(name);
    }
    /**
     * @see com.altima.validation.services.ConsoleService#saveAllConsoles(List<Console> )
     */
    @Override
    public void saveAllConsoles(List<Console> consoles)  {

            consoleRepository.saveAll(consoles);


    }
}
