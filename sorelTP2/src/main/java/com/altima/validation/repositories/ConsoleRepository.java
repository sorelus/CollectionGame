package com.altima.validation.repositories;

import com.altima.validation.entities.Console;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
/**
 * ConsoleRepository interface
 * Repository for console (use by Hibernate to get,save, update console table)
 * @author sorelus Mkounga
 */
@Repository
public interface ConsoleRepository  extends JpaRepository<Console, Integer> {

        /*
        function to get all consoles order by  dateDeSortie
        */
    @Query("select c from Console c order by c.dateDeSortie")
    List<Console> getByDateDeSortie();

    /*
    function to get  specific console  using it name
    */
    @Query("select c from Console c where c.nom = ?1")
    Console getByName(String name);

}
