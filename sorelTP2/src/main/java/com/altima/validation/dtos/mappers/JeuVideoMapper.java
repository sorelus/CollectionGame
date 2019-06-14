package com.altima.validation.dtos.mappers;

import com.altima.validation.dtos.entities.JeuVideoDto;
import com.altima.validation.entities.JeuVideo;
import org.mapstruct.Mapper;

/**
 * JeuVideoMapper interface  it is mapper logical for JeuVideo <-> JeuVideoDto ( using mapstruct library)
 * @author sorelus Mkounga
 */
@Mapper
public interface JeuVideoMapper extends EntityMapper<JeuVideo, JeuVideoDto> {


}
