package com.altima.validation.dtos.mappers;

import java.util.List;

/**
 * EntityMapper interface  it is  parent of all our mapper interface ( using mapstruct library)
 *
 * @author sorelus Mkounga
 */
public interface EntityMapper<E, D> {
    /**
     * map dto to entity
     *
     * @param d entity object
     * @return dtos object
     */
    E toEntity(D d);

    /**
     * map dto to entity
     *
     * @param e dtos object
     * @return entity object
     */
    D toDto(E e);

    /**
     * map list entities to list dtos
     *
     * @param t list entities  object
     * @return list dtos object
     */
    List<D> toDtos(List<E> t);

    /**
     * map list dtos to list entities
     *
     * @param t list mapper  object
     * @return list dtos object
     */
    List<E> toEntities(List<D> t);
}
