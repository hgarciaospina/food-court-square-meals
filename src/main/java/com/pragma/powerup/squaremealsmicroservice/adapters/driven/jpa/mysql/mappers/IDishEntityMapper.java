package com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.mappers;

import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.entity.CategoryEntity;
import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.entity.DishEntity;
import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.request.CategoryRequestDto;
import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.request.DishRequestDto;
import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.response.CategoryResponseDto;
import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.response.DishResponseDto;
import com.pragma.powerup.squaremealsmicroservice.domain.model.Category;
import com.pragma.powerup.squaremealsmicroservice.domain.model.Dish;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IDishEntityMapper {
    DishEntity entityToModel(Dish dish);
    Dish modelToEntity(DishEntity dishEntity);
    DishResponseDto responseDtoToEntity(DishEntity dishEntity);
    Dish requestDtoToModel(DishRequestDto dishRequestDto);
}