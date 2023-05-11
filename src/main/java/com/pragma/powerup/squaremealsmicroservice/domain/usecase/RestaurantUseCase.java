package com.pragma.powerup.squaremealsmicroservice.domain.usecase;

import com.pragma.powerup.squaremealsmicroservice.domain.api.IRestaurantServicePort;
import com.pragma.powerup.squaremealsmicroservice.domain.model.Restaurant;
import com.pragma.powerup.squaremealsmicroservice.domain.spi.IRestaurantPersistencePort;

public class RestaurantUseCase implements IRestaurantServicePort {
    private final IRestaurantPersistencePort restaurantPersistencePort;

    public RestaurantUseCase(IRestaurantPersistencePort personPersistencePort) {
        this.restaurantPersistencePort = personPersistencePort;
    }

    @Override
    public void saveRestaurant(Restaurant restaurant) {
        restaurantPersistencePort.saveRestaurant(restaurant);
    }
}
