package com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.mappers;

import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.entity.RestaurantEntity;
import com.pragma.powerup.squaremealsmicroservice.domain.model.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRestaurantEntityMapper {
    @Mapping(source = "idOwner", target = "idUser")
    RestaurantEntity toEntity(Restaurant restaurant);
}
