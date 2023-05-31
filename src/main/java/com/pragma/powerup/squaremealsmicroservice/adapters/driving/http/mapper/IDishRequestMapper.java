package com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.mapper;

import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.request.DishRequestDto;
import com.pragma.powerup.squaremealsmicroservice.domain.model.Dish;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IDishRequestMapper {
    Dish requestDtoToModel(DishRequestDto dishRequestDto);
}