package com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.handlers.impl;

import com.pragma.powerup.squaremealsmicroservice.adapters.driven.feignclient.UserFeignClientImpl;
import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.exceptions.OwnerIsNotException;
import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.request.RestaurantRequestDto;
import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.response.RestaurantResponseDto;
import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.handlers.IRestaurantHandler;
import com.pragma.powerup.squaremealsmicroservice.domain.api.IRestaurantServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestaurantHandlerImpl implements IRestaurantHandler {
    private final IRestaurantServicePort restaurantServicePort;
    private final UserFeignClientImpl userFeignClient;

    @Override
    public RestaurantResponseDto saveRestaurant(RestaurantRequestDto restaurantRequestDto) {
        if (userFeignClient.isOwnerUser(restaurantRequestDto.getIdOwner()))
            return restaurantServicePort.saveRestaurant(restaurantRequestDto);
        throw new OwnerIsNotException();
    }
}