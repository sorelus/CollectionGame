package com.altima.validation.dtos.mappers;

import com.altima.validation.dtos.entities.ConsoleDto;
import com.altima.validation.entities.Console;
import org.mapstruct.Mapper;

/**
 * ConsoleMapper interface  it is mapper logical for Console <-> consoleDto ( using mapstruct library)
 *
 * @author sorelus Mkounga
 */
@Mapper
public interface ConsoleMapper extends EntityMapper<Console, ConsoleDto> {


}
