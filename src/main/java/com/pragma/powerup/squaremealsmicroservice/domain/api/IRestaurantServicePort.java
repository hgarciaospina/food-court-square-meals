package com.pragma.powerup.squaremealsmicroservice.domain.api;

import com.pragma.powerup.squaremealsmicroservice.domain.model.Restaurant;

public interface IRestaurantServicePort {
    void saveRestaurant(Restaurant restaurant);
}
