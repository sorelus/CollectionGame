package com.altima.validation.services.impl;

import com.altima.validation.entities.JeuVideo;
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

    /**
     * @see com.altima.validation.services.JeuVideoService#saveJeu(JeuVideo)
     */
    @Override
    public void saveJeu(JeuVideo jeu) {
        jeuVideoRepository.save(jeu);
    }

    /**
     * @see com.altima.validation.services.JeuVideoService#getAllOrderByConsoleThenByDate()
     */
    @Override
    public List<JeuVideo> getAllOrderByConsoleThenByDate() {
       return jeuVideoRepository.getByConsoleAndDateDeSortie();
    }

    /**
     * @see com.altima.validation.services.JeuVideoService#getJeuByName(String )
     */
    @Override
    public JeuVideo getJeuByName(String name) {
        return jeuVideoRepository.getByName(name);
    }

    /**
     * @see com.altima.validation.services.JeuVideoService#saveAllJeux(List<JeuVideo> )
     */
    @Override
    public void saveAllJeux(List<JeuVideo> jeux) {
        jeuVideoRepository.saveAll(jeux);
    }
}
