package com.altima.validation.dtos.mappers;
import com.altima.validation.dtos.entities.UserDto;
import com.altima.validation.entities.User;
import org.mapstruct.Mapper;

/**
 * UserMapper interface  it is mapper logical for User <-> UserDto ( using mapstruct library)
 * @author sorelus Mkounga
 */
@Mapper
public interface UserMapper extends EntityMapper<User, UserDto> {


}
