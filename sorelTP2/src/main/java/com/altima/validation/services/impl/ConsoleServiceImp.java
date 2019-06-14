package com.altima.validation.services.impl;

import com.altima.validation.dtos.entities.ConsoleDto;
import com.altima.validation.dtos.mappers.ConsoleMapper;
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

    @Autowired
    ConsoleMapper consoleMapper;

    /**
     * @see com.altima.validation.services.ConsoleService#saveConsole(ConsoleDto)
     */
    @Override
    public void saveConsole(ConsoleDto console){
        consoleRepository.save(consoleMapper.toEntity(console));
    }
    /**
     * @see com.altima.validation.services.ConsoleService#getAllOrderByDate()
     */
    @Override
    public List<ConsoleDto> getAllOrderByDate() {
        return consoleMapper.toDtos(consoleRepository.getByDateDeSortie());
    }
    /**
     * @see com.altima.validation.services.ConsoleService#getConsoleByName(String )
     */
    @Override
    public ConsoleDto getConsoleByName(String name) {
        return consoleMapper.toDto(consoleRepository.getByName(name));
    }

    @Override
    public ConsoleDto getConsoleId(int id) {
        return consoleMapper.toDto(consoleRepository.getOne(id));
    }

    /**
     * @see com.altima.validation.services.ConsoleService#saveAllConsoles(List<ConsoleDto> )
     */
    @Override
    public void saveAllConsoles(List<ConsoleDto> consoles)  {

       consoleRepository.saveAll( consoleMapper.toEntities(consoles));


    }
}
