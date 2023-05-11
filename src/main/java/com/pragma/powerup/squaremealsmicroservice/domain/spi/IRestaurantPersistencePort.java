package com.pragma.powerup.squaremealsmicroservice.domain.spi;

import com.pragma.powerup.squaremealsmicroservice.domain.model.Restaurant;

public interface IRestaurantPersistencePort {
    void saveRestaurant(Restaurant restaurant);
}
