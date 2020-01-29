package com.altima.validation.dtos.mappers;

import com.altima.validation.dtos.entities.ConsoleDto;
import com.altima.validation.dtos.entities.JeuVideoDto;
import com.altima.validation.entities.Console;
import com.altima.validation.entities.JeuVideo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.2.0.Final, compiler: Eclipse JDT (IDE) 3.19.0.v20190713-1602, environment: Java 1.8.0_181 (Oracle Corporation)"
)
@Component
public class JeuVideoMapperImpl implements JeuVideoMapper {

    @Override
    public JeuVideo toEntity(JeuVideoDto d) {
        if ( d == null ) {
            return null;
        }

        JeuVideo jeuVideo = new JeuVideo();

        jeuVideo.setNom( d.getNom() );
        jeuVideo.setEditeur( d.getEditeur() );
        jeuVideo.setDateDeSortie( d.getDateDeSortie() );
        jeuVideo.setConsole( consoleDtoToConsole( d.getConsole() ) );
        jeuVideo.setId( d.getId() );
        jeuVideo.setJaquette( d.getJaquette() );

        return jeuVideo;
    }

    @Override
    public JeuVideoDto toDto(JeuVideo e) {
        if ( e == null ) {
            return null;
        }

        JeuVideoDto jeuVideoDto = new JeuVideoDto();

        jeuVideoDto.setNom( e.getNom() );
        jeuVideoDto.setEditeur( e.getEditeur() );
        jeuVideoDto.setDateDeSortie( e.getDateDeSortie() );
        jeuVideoDto.setConsole( consoleToConsoleDto( e.getConsole() ) );
        jeuVideoDto.setId( e.getId() );
        jeuVideoDto.setJaquette( e.getJaquette() );

        return jeuVideoDto;
    }

    @Override
    public List<JeuVideoDto> toDtos(List<JeuVideo> t) {
        if ( t == null ) {
            return null;
        }

        List<JeuVideoDto> list = new ArrayList<JeuVideoDto>( t.size() );
        for ( JeuVideo jeuVideo : t ) {
            list.add( toDto( jeuVideo ) );
        }

        return list;
    }

    @Override
    public List<JeuVideo> toEntities(List<JeuVideoDto> t) {
        if ( t == null ) {
            return null;
        }

        List<JeuVideo> list = new ArrayList<JeuVideo>( t.size() );
        for ( JeuVideoDto jeuVideoDto : t ) {
            list.add( toEntity( jeuVideoDto ) );
        }

        return list;
    }

    protected Console consoleDtoToConsole(ConsoleDto consoleDto) {
        if ( consoleDto == null ) {
            return null;
        }

        Console console = new Console();

        console.setNom( consoleDto.getNom() );
        console.setDateDeSortie( consoleDto.getDateDeSortie() );
        console.setFabricant( consoleDto.getFabricant() );
        console.setBits( consoleDto.getBits() );
        console.setId( consoleDto.getId() );

        return console;
    }

    protected ConsoleDto consoleToConsoleDto(Console console) {
        if ( console == null ) {
            return null;
        }

        ConsoleDto consoleDto = new ConsoleDto();

        consoleDto.setNom( console.getNom() );
        consoleDto.setDateDeSortie( console.getDateDeSortie() );
        consoleDto.setFabricant( console.getFabricant() );
        consoleDto.setBits( console.getBits() );
        consoleDto.setId( console.getId() );

        return consoleDto;
    }
}
