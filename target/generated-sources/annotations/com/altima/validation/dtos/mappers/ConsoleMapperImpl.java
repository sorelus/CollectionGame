package com.altima.validation.dtos.mappers;

import com.altima.validation.dtos.entities.ConsoleDto;
import com.altima.validation.entities.Console;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.2.0.Final, compiler: Eclipse JDT (IDE) 3.19.0.v20190713-1602, environment: Java 1.8.0_181 (Oracle Corporation)"
)
@Component
public class ConsoleMapperImpl implements ConsoleMapper {

    @Override
    public Console toEntity(ConsoleDto d) {
        if ( d == null ) {
            return null;
        }

        Console console = new Console();

        console.setNom( d.getNom() );
        console.setDateDeSortie( d.getDateDeSortie() );
        console.setFabricant( d.getFabricant() );
        console.setBits( d.getBits() );
        console.setId( d.getId() );

        return console;
    }

    @Override
    public ConsoleDto toDto(Console e) {
        if ( e == null ) {
            return null;
        }

        ConsoleDto consoleDto = new ConsoleDto();

        consoleDto.setNom( e.getNom() );
        consoleDto.setDateDeSortie( e.getDateDeSortie() );
        consoleDto.setFabricant( e.getFabricant() );
        consoleDto.setBits( e.getBits() );
        consoleDto.setId( e.getId() );

        return consoleDto;
    }

    @Override
    public List<ConsoleDto> toDtos(List<Console> t) {
        if ( t == null ) {
            return null;
        }

        List<ConsoleDto> list = new ArrayList<ConsoleDto>( t.size() );
        for ( Console console : t ) {
            list.add( toDto( console ) );
        }

        return list;
    }

    @Override
    public List<Console> toEntities(List<ConsoleDto> t) {
        if ( t == null ) {
            return null;
        }

        List<Console> list = new ArrayList<Console>( t.size() );
        for ( ConsoleDto consoleDto : t ) {
            list.add( toEntity( consoleDto ) );
        }

        return list;
    }
}
