package com.pragma.powerup.squaremealsmicroservice.domain.usecase;

import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.mappers.IRestaurantEntityMapper;
import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.request.RestaurantRequestDto;
import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.response.RestaurantResponseDto;
import com.pragma.powerup.squaremealsmicroservice.domain.api.IRestaurantServicePort;
import com.pragma.powerup.squaremealsmicroservice.domain.exceptions.TinLengthInvalidException;
import com.pragma.powerup.squaremealsmicroservice.domain.spi.IRestaurantPersistencePort;
import com.pragma.powerup.squaremealsmicroservice.domain.validations.RestaurantValidation;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RestaurantUseCase implements IRestaurantServicePort {
    private final IRestaurantPersistencePort restaurantPersistencePort;
    private final IRestaurantEntityMapper restaurantEntityMapper;

    @Override
    public RestaurantResponseDto saveRestaurant(RestaurantRequestDto restaurantRequestDto) {
        validations(restaurantRequestDto);
        return restaurantPersistencePort.saveRestaurant(restaurantEntityMapper.toDomain(restaurantRequestDto));
    }

    private void validations(RestaurantRequestDto restaurantRequestDto) {

        if (!RestaurantValidation.lengthValidTinNumber(restaurantRequestDto.getTin()))
            throw new TinLengthInvalidException();

    }
}