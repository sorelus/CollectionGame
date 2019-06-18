package com.altima.validation.repositories;
import com.altima.validation.entities.JeuVideo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * JeuVideoRepository interface
 * Repository for jeuVideo (use by Hibernate to get,save, update jeuVideo table)
 * @author sorelus Mkounga
 */
@Repository
public interface JeuVideoRepository  extends JpaRepository<JeuVideo, Integer> {

    /*
     function to get all jeuvideo order by console then dateDeSortie
     */
    @Query("select j from JeuVideo j order by j.console ,j.dateDeSortie")
    List<JeuVideo> getByConsoleAndDateDeSortie();

    /*
     function to get  specific jeuvideos using it name
     */
    @Query("select j from JeuVideo j where j.nom = ?1")
    JeuVideo getByName(String name);



}
