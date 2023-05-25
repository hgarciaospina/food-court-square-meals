package com.pragma.powerup.squaremealsmicroservice.domain.api;

import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.request.RestaurantRequestDto;
import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.response.RestaurantResponseDto;

public interface IRestaurantServicePort {
    RestaurantResponseDto saveRestaurant(RestaurantRequestDto restaurantRequestDto);
}