package com.altima.validation.services;

import com.altima.validation.dtos.entities.UserDto;
import com.altima.validation.utilis.JeuException;

import java.util.List;

/**
 * UserService interface
 * @author sorelus Mkounga
 */
public interface UserService {
    /**
     * Save user to DB
     * @param user data we want to save in DB
     * @throws JeuException when an error occurs during treatment
     */
    public void saveUser(UserDto user)throws JeuException;

    /**
     * get all users
     * @return list of all users
     * @throws JeuException when an error occurs during treatment
     */
    public List<UserDto> getAllUsers()throws JeuException;

    /**
     * get user by login
     * @param login login of user we want to get
     * @return user information
     * @throws JeuException when an error occurs during treatment
     */
    public UserDto getByLogin(String login)throws JeuException;

}
