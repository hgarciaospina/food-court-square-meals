package com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.mapper;

import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.entity.DishEntity;
import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.response.DishResponseDto;
import com.pragma.powerup.squaremealsmicroservice.domain.model.Dish;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IDishResponseMapper {
    DishResponseDto entityToResponseDto(DishEntity dishEntity);
    List<DishResponseDto> responseDtoListToModelList(List<Dish> dishList);
}