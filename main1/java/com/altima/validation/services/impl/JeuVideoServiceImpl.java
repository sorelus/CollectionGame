package com.altima.validation.services.impl;

import com.altima.validation.dtos.entities.JeuVideoDto;
import com.altima.validation.dtos.mappers.JeuVideoMapper;
import com.altima.validation.repositories.JeuVideoRepository;
import com.altima.validation.services.JeuVideoService;
import com.altima.validation.utilis.JeuException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * JeuVideoServiceImpl class
 *
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
    public void saveJeu(JeuVideoDto jeu) throws JeuException {
        try {
            jeuVideoRepository.save(jeuVideoMapper.toEntity(jeu));
        } catch (Exception ex) {
            throw new JeuException(ex.getMessage());
        }
    }

    /**
     * @see com.altima.validation.services.JeuVideoService#getAllOrderByConsoleThenByDate()
     */
    @Override
    public List<JeuVideoDto> getAllOrderByConsoleThenByDate() throws JeuException {
        try {
            return jeuVideoMapper.toDtos(jeuVideoRepository.getByConsoleAndDateDeSortie());
        } catch (Exception ex) {
            throw new JeuException(ex.getMessage());
        }
    }

    /**
     * @see com.altima.validation.services.JeuVideoService#getJeuByName(String)
     */
    @Override
    public JeuVideoDto getJeuByName(String name) throws JeuException {
        try {
            return jeuVideoMapper.toDto(jeuVideoRepository.getByName(name));
        } catch (Exception ex) {
            throw new JeuException(ex.getMessage());
        }
    }

    /**
     * @see com.altima.validation.services.JeuVideoService#saveAllJeux(List<JeuVideoDto> )
     */
    @Override
    public void saveAllJeux(List<JeuVideoDto> jeux) throws JeuException {
        try {
            jeuVideoRepository.saveAll(jeuVideoMapper.toEntities(jeux));
        } catch (Exception ex) {
            throw new JeuException(ex.getMessage());
        }
    }

    @Override
    public JeuVideoDto getJeuById(int id) throws JeuException {
        try {
            return jeuVideoMapper.toDto(jeuVideoRepository.getOne(id));
        } catch (Exception ex) {
            throw new JeuException(ex.getMessage());
        }
    }
}
