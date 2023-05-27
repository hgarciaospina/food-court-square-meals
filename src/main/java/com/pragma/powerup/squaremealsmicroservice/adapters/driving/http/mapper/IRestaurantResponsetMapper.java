package com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.mapper;

import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.entity.RestaurantEntity;
import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.response.RestaurantResponseDto;
import com.pragma.powerup.squaremealsmicroservice.domain.model.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IRestaurantResponsetMapper {
    RestaurantResponseDto entityToResponseDto(RestaurantEntity restaurantEntity);
    List<RestaurantResponseDto> responseDtoListToModelList(List<Restaurant> restaurantList);
}