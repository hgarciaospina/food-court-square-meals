package com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.adapter;

import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.exceptions.NameAlreadyExistsException;
import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.exceptions.TinAlreadyExistsException;
import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.mappers.IRestaurantEntityMapper;
import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.repositories.IRestaurantRepository;
import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.response.RestaurantResponseDto;
import com.pragma.powerup.squaremealsmicroservice.domain.model.Restaurant;
import com.pragma.powerup.squaremealsmicroservice.domain.spi.IRestaurantPersistencePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RestaurantMysqlAdapter implements IRestaurantPersistencePort {
    private final IRestaurantRepository restaurantRepository;
    private final IRestaurantEntityMapper restaurantEntityMapper;

    @Override
    public RestaurantResponseDto saveRestaurant(Restaurant restaurant) {
        if (restaurantRepository.findByTin(restaurant.getTin()).isPresent()) {
            throw new TinAlreadyExistsException();
        }

        if (restaurantRepository.existsByName(restaurant.getName())){
            throw new NameAlreadyExistsException();
        }

        return restaurantEntityMapper.toRestaurantResponseDto(restaurantRepository.save(restaurantEntityMapper.toEntity(restaurant)));
    }
}