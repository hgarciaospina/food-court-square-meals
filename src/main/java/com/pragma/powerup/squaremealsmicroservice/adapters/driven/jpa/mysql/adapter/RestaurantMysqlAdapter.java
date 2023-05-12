package com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.adapter;

import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.exceptions.NameAlreadyExistsException;
import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.exceptions.RestaurantAlreadyExistsException;
import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.mappers.IRestaurantEntityMapper;
import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.repositories.IRestaurantRepository;
import com.pragma.powerup.squaremealsmicroservice.domain.model.Restaurant;
import com.pragma.powerup.squaremealsmicroservice.domain.spi.IRestaurantPersistencePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class RestaurantMysqlAdapter implements IRestaurantPersistencePort {
    private final IRestaurantRepository restaurantRepository;
    private final IRestaurantEntityMapper restaurantEntityMapper;

    @Override
    public void saveRestaurant(Restaurant restaurant) {
        if (restaurantRepository.findByTin(restaurant.getTin()).isPresent()) {
            throw new RestaurantAlreadyExistsException();
        }

        if (restaurantRepository.existsByName(restaurant.getName())){
            throw new NameAlreadyExistsException();
        }



        restaurantRepository.save(restaurantEntityMapper.toEntity(restaurant));
    }
}
