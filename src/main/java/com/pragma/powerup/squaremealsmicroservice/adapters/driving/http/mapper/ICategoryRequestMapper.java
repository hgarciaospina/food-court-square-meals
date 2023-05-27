package com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.mapper;

import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.request.RestaurantRequestDto;
import com.pragma.powerup.squaremealsmicroservice.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ICategoryRequestMapper {
    Category requestDtoToModel(RestaurantRequestDto restaurantRequestDto);
}