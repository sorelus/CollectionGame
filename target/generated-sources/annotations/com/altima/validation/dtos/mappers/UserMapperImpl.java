package com.altima.validation.dtos.mappers;

import com.altima.validation.dtos.entities.ConsoleDto;
import com.altima.validation.dtos.entities.JeuVideoDto;
import com.altima.validation.dtos.entities.UserDto;
import com.altima.validation.entities.Console;
import com.altima.validation.entities.JeuVideo;
import com.altima.validation.entities.User;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    comments = "version: 1.2.0.Final, compiler: Eclipse JDT (IDE) 3.19.0.v20190713-1602, environment: Java 1.8.0_181 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserDto d) {
        if ( d == null ) {
            return null;
        }

        User user = new User();

        user.setId( d.getId() );
        user.setNom( d.getNom() );
        user.setPrenom( d.getPrenom() );
        user.setLogin( d.getLogin() );
        user.setPass( d.getPass() );
        user.setDateDeNaissance( d.getDateDeNaissance() );
        user.setCollection( jeuVideoDtoSetToJeuVideoSet( d.getCollection() ) );
        Set<String> set1 = d.getRoles();
        if ( set1 != null ) {
            user.setRoles( new HashSet<String>( set1 ) );
        }
        else {
            user.setRoles( null );
        }

        return user;
    }

    @Override
    public UserDto toDto(User e) {
        if ( e == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setId( e.getId() );
        userDto.setNom( e.getNom() );
        userDto.setPrenom( e.getPrenom() );
        userDto.setLogin( e.getLogin() );
        userDto.setPass( e.getPass() );
        userDto.setDateDeNaissance( e.getDateDeNaissance() );
        userDto.setCollection( jeuVideoSetToJeuVideoDtoSet( e.getCollection() ) );
        Set<String> set1 = e.getRoles();
        if ( set1 != null ) {
            userDto.setRoles( new HashSet<String>( set1 ) );
        }
        else {
            userDto.setRoles( null );
        }

        return userDto;
    }

    @Override
    public List<UserDto> toDtos(List<User> t) {
        if ( t == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( t.size() );
        for ( User user : t ) {
            list.add( toDto( user ) );
        }

        return list;
    }

    @Override
    public List<User> toEntities(List<UserDto> t) {
        if ( t == null ) {
            return null;
        }

        List<User> list = new ArrayList<User>( t.size() );
        for ( UserDto userDto : t ) {
            list.add( toEntity( userDto ) );
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

    protected JeuVideo jeuVideoDtoToJeuVideo(JeuVideoDto jeuVideoDto) {
        if ( jeuVideoDto == null ) {
            return null;
        }

        JeuVideo jeuVideo = new JeuVideo();

        jeuVideo.setNom( jeuVideoDto.getNom() );
        jeuVideo.setEditeur( jeuVideoDto.getEditeur() );
        jeuVideo.setDateDeSortie( jeuVideoDto.getDateDeSortie() );
        jeuVideo.setConsole( consoleDtoToConsole( jeuVideoDto.getConsole() ) );
        jeuVideo.setId( jeuVideoDto.getId() );
        jeuVideo.setJaquette( jeuVideoDto.getJaquette() );

        return jeuVideo;
    }

    protected Set<JeuVideo> jeuVideoDtoSetToJeuVideoSet(Set<JeuVideoDto> set) {
        if ( set == null ) {
            return null;
        }

        Set<JeuVideo> set1 = new HashSet<JeuVideo>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( JeuVideoDto jeuVideoDto : set ) {
            set1.add( jeuVideoDtoToJeuVideo( jeuVideoDto ) );
        }

        return set1;
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

    protected JeuVideoDto jeuVideoToJeuVideoDto(JeuVideo jeuVideo) {
        if ( jeuVideo == null ) {
            return null;
        }

        JeuVideoDto jeuVideoDto = new JeuVideoDto();

        jeuVideoDto.setNom( jeuVideo.getNom() );
        jeuVideoDto.setEditeur( jeuVideo.getEditeur() );
        jeuVideoDto.setDateDeSortie( jeuVideo.getDateDeSortie() );
        jeuVideoDto.setConsole( consoleToConsoleDto( jeuVideo.getConsole() ) );
        jeuVideoDto.setId( jeuVideo.getId() );
        jeuVideoDto.setJaquette( jeuVideo.getJaquette() );

        return jeuVideoDto;
    }

    protected Set<JeuVideoDto> jeuVideoSetToJeuVideoDtoSet(Set<JeuVideo> set) {
        if ( set == null ) {
            return null;
        }

        Set<JeuVideoDto> set1 = new HashSet<JeuVideoDto>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( JeuVideo jeuVideo : set ) {
            set1.add( jeuVideoToJeuVideoDto( jeuVideo ) );
        }

        return set1;
    }
}
