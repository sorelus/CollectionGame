package com.altima.validation.repositories;

import com.altima.validation.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


/**
 * UserRepository interface
 * Repository for User (use by Hibernate to get,save, update console table)
 * @author sorelus Mkounga
 */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {



}
