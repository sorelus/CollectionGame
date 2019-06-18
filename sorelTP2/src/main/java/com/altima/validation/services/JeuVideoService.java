package com.altima.validation.services;

import com.altima.validation.dtos.entities.JeuVideoDto;
import com.altima.validation.utilis.JeuException;

import java.util.List;
/**
 * JeuVideoService interface
 * @author sorelus Mkounga
 */
public interface JeuVideoService {
    /**
     * save one JeuVideo to DB
     * @param jeu , jeuVideo to save
     * @throws JeuException when an error occurs during treatment
     */
    void saveJeu(JeuVideoDto jeu) throws JeuException;

    /**
     * get all JeuVideos order by console them create date
     * @return sort JeuVideos
     * @throws JeuException when an error occurs during treatment
     */
    List<JeuVideoDto> getAllOrderByConsoleThenByDate () throws JeuException;

    /**
     * get an specific JeuVideo identify by name
     * @param name name of specific JeuVideo that we want to get
     * @return JeuVideo information return by DB
     * @throws JeuException when an error occurs during treatment
     */
    JeuVideoDto getJeuByName(String name) throws JeuException;

    /**
     * save list of JeuVideo
     * @param jeux list of JeuVideo to save
     * @throws JeuException when an error occurs during treatment
     */
    void saveAllJeux(List<JeuVideoDto> jeux) throws JeuException;


    /**
     * get an specific JeuVideo identify by id
     * @param id id of specific JeuVideo that we want to get
     * @return JeuVideo information return by DB
     * @throws JeuException when an error occurs during treatment
     */
    JeuVideoDto getJeuById(int id) throws JeuException;

}
