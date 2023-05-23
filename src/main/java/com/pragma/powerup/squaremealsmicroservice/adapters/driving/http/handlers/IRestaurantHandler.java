package com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.handlers;

import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.request.RestaurantRequestDto;
import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.response.RestaurantResponseDto;

public interface IRestaurantHandler {
    RestaurantResponseDto saveRestaurant(RestaurantRequestDto restaurantRequestDto);
}
