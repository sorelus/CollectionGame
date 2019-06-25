package com.altima.validation.services.impl;

import com.altima.validation.dtos.entities.UserDto;
import com.altima.validation.dtos.mappers.UserMapper;
import com.altima.validation.entities.User;
import com.altima.validation.repositories.UserRepository;
import com.altima.validation.services.UserService;
import com.altima.validation.utilis.JeuException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserServiceImp class
 *
 * @author sorelus Mkounga
 */
@Service
public class UserServiceImp implements UserService {

    @Autowired
    UserMapper userMapper;

    @Autowired
    UserRepository userRepository;

    /**
     * @see com.altima.validation.services.UserService#saveUser(UserDto)
     */
    @Override
    public void saveUser(UserDto user) throws JeuException {
        try {
            User userEnity = userMapper.toEntity(user);
            userRepository.save(userEnity);
        } catch (Exception ex) {
            throw new JeuException(ex.getMessage());
        }
    }

    /**
     * @see com.altima.validation.services.UserService#getAllUsers()
     */
    @Override
    public List<UserDto> getAllUsers() throws JeuException {
        List<UserDto> userEnities = null;
        try {
            userEnities = userMapper.toDtos(userRepository.findAll());

        } catch (Exception ex) {
            throw new JeuException(ex.getMessage());
        }
        return userEnities;
    }

    /**
     * @see com.altima.validation.services.UserService#getByLogin(String)
     */
    @Override
    public UserDto getByLogin(String login) throws JeuException {
        UserDto user = null;
        try {
            user = userMapper.toDto(userRepository.getByLogin(login));

        } catch (Exception ex) {
            throw new JeuException(ex.getMessage());
        }
        return user;
    }

    @Override
    public UserDto getById(int id) throws JeuException {
        return userMapper.toDto(userRepository.getOne(id));
    }

}
