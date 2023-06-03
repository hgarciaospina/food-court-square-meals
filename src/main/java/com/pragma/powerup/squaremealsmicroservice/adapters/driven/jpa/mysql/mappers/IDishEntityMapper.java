package com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.mappers;

import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.entity.DishEntity;
import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.request.DishRequestDto;
import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.response.DishResponseDto;
import com.pragma.powerup.squaremealsmicroservice.domain.model.Dish;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IDishEntityMapper {
    @Mapping(target = "categoryEntity", source = "dish.category")
    @Mapping(target = "restaurantEntity", source = "dish.restaurant")
    DishEntity entityToModel(Dish dish);
    Dish modelToEntity(DishEntity dishEntity);
    @Mapping(target = "categoryName", source = "categoryEntity.name")
    @Mapping(target = "restaurantName", source = "restaurantEntity.name")
    DishResponseDto entityToResponseDto(DishEntity dishEntity);
    Dish requestDtoToModel(DishRequestDto dishRequestDto);
    DishResponseDto requestDtoToResponseDto(DishRequestDto dishRequestDto);
    Dish responseDtoToModel(DishResponseDto dishResponseDto);
}