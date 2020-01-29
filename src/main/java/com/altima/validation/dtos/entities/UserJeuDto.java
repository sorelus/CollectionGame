package com.altima.validation.dtos.entities;

public class UserJeuDto {
    private JeuVideoDto jeuVideoDto;
    private UserDto userDto;

    public JeuVideoDto getJeuVideoDto() {
        return jeuVideoDto;
    }

    public void setJeuVideoDto(JeuVideoDto jeuVideoDto) {
        this.jeuVideoDto = jeuVideoDto;
    }

    public UserDto getUserDto() {
        return userDto;
    }

    public void setUserDto(UserDto userDto) {
        this.userDto = userDto;
    }
}