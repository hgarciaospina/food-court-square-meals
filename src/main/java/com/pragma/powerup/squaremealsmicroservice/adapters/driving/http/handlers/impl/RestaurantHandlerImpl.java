package com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.handlers.impl;

import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.request.RestaurantRequestDto;
import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.handlers.IRestaurantHandler;
import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.mapper.IRestaurantRequestMapper;
import com.pragma.powerup.squaremealsmicroservice.domain.api.IRestaurantServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestaurantHandlerImpl implements IRestaurantHandler {
    private final IRestaurantServicePort restaurantServicePort;
    private final IRestaurantRequestMapper restaurantRequestMapper;

    @Override
    public void saveRestaurant(RestaurantRequestDto restaurantRequestDto) {
        restaurantServicePort.saveRestaurant(restaurantRequestMapper.toRestaurant(restaurantRequestDto));
    }
}