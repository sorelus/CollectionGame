package com.altima.validation.services;

import com.altima.validation.dtos.entities.JeuVideoDto;

import java.util.List;
/**
 * JeuVideoService interface
 * @author sorelus Mkounga
 */
public interface JeuVideoService {
    /**
     * save one JeuVideo to DB
     * @param jeu , jeuVideo to save
     */
    void saveJeu(JeuVideoDto jeu);

    /**
     * get all JeuVideos order by console them create date
     * @return sort JeuVideos
     */
    List<JeuVideoDto> getAllOrderByConsoleThenByDate ();

    /**
     * get an specific JeuVideo identify by name
     * @param name name of specific JeuVideo that we want to get
     * @return JeuVideo information return by DB
     */
    JeuVideoDto getJeuByName(String name);

    /**
     * save list of JeuVideo
     * @param jeux list of JeuVideo to save
     */
    void saveAllJeux(List<JeuVideoDto> jeux) ;


    /**
     * get an specific JeuVideo identify by id
     * @param id id of specific JeuVideo that we want to get
     * @return JeuVideo information return by DB
     */
    JeuVideoDto getJeuById(int id);

}
