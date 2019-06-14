package com.altima.validation.services.impl;

import com.altima.validation.dtos.entities.JeuVideoDto;
import com.altima.validation.dtos.mappers.JeuVideoMapper;
import com.altima.validation.repositories.JeuVideoRepository;
import com.altima.validation.services.JeuVideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
/**
 * JeuVideoServiceImpl class
 * @author sorelus Mkounga
 */
@Service
public class JeuVideoServiceImpl implements JeuVideoService {

    @Autowired
    JeuVideoRepository jeuVideoRepository;


    @Autowired
    JeuVideoMapper jeuVideoMapper;

    /**
     * @see com.altima.validation.services.JeuVideoService#saveJeu(JeuVideoDto)
     */
    @Override
    public void saveJeu(JeuVideoDto jeu) {
        jeuVideoRepository.save(jeuVideoMapper.toEntity(jeu));
    }

    /**
     * @see com.altima.validation.services.JeuVideoService#getAllOrderByConsoleThenByDate()
     */
    @Override
    public List<JeuVideoDto> getAllOrderByConsoleThenByDate() {
       return jeuVideoMapper.toDtos(jeuVideoRepository.getByConsoleAndDateDeSortie());
    }

    /**
     * @see com.altima.validation.services.JeuVideoService#getJeuByName(String )
     */
    @Override
    public JeuVideoDto getJeuByName(String name) {
        return jeuVideoMapper.toDto(jeuVideoRepository.getByName(name));
    }

    /**
     * @see com.altima.validation.services.JeuVideoService#saveAllJeux(List<JeuVideoDto> )
     */
    @Override
    public void saveAllJeux(List<JeuVideoDto> jeux) {
        jeuVideoRepository.saveAll(jeuVideoMapper.toEntities(jeux));
    }

    @Override
    public JeuVideoDto getJeuById(int id) {
        return jeuVideoMapper.toDto(jeuVideoRepository.getOne(id));
    }
}
