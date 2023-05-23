package com.pragma.powerup.squaremealsmicroservice.domain.spi;
import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.response.RestaurantResponseDto;
import com.pragma.powerup.squaremealsmicroservice.domain.model.Restaurant;

public interface IRestaurantPersistencePort {
    RestaurantResponseDto saveRestaurant(Restaurant restaurant);
}
