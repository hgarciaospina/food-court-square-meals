package com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.handlers;

import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.request.RestaurantRequestDto;

public interface IRestaurantHandler {
    void saveRestaurant(RestaurantRequestDto restaurantRequestDto);
}
