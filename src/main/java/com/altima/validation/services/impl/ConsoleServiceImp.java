package com.altima.validation.services.impl;

import com.altima.validation.dtos.entities.ConsoleDto;
import com.altima.validation.dtos.mappers.ConsoleMapper;
import com.altima.validation.repositories.ConsoleRepository;
import com.altima.validation.services.ConsoleService;
import com.altima.validation.utilis.JeuException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * ConsoleServiceImp class
 *
 * @author sorelus Mkounga
 */
@Service
public class ConsoleServiceImp implements ConsoleService {

    @Autowired
    ConsoleRepository consoleRepository;

    @Autowired
    ConsoleMapper consoleMapper;

    /**
     * @see com.altima.validation.services.ConsoleService#saveConsole(ConsoleDto)
     */
    @Override
    public void saveConsole(ConsoleDto console) throws JeuException {
        try {
            consoleRepository.save(consoleMapper.toEntity(console));
        } catch (Exception ex) {
            throw new JeuException(ex.getMessage());
        }
    }

    /**
     * @see com.altima.validation.services.ConsoleService#getAllOrderByDate()
     */
    @Override
    public List<ConsoleDto> getAllOrderByDate() throws JeuException {
        try {
            return consoleMapper.toDtos(consoleRepository.getByDateDeSortie());
        } catch (Exception ex) {
            throw new JeuException(ex.getMessage());
        }
    }

    /**
     * @see com.altima.validation.services.ConsoleService#getConsoleByName(String)
     */
    @Override
    public ConsoleDto getConsoleByName(String name) throws JeuException {
        try {
            return consoleMapper.toDto(consoleRepository.getByName(name));
        } catch (Exception ex) {
            throw new JeuException(ex.getMessage());
        }
    }

    @Override
    public ConsoleDto getConsoleId(int id) throws JeuException {
        try {
            return consoleMapper.toDto(consoleRepository.getOne(id));
        } catch (Exception ex) {
            throw new JeuException(ex.getMessage());
        }
    }

    /**
     * @see com.altima.validation.services.ConsoleService#saveAllConsoles(List<ConsoleDto> )
     */
    @Override
    public void saveAllConsoles(List<ConsoleDto> consoles) throws JeuException {
        try {
            consoleRepository.saveAll(
                    consoleMapper.toEntities(consoles));
        } catch (Exception ex) {
            throw new JeuException(ex.getMessage());
        }

    }
}
