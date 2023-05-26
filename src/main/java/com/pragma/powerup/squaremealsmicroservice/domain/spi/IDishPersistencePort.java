package com.pragma.powerup.squaremealsmicroservice.domain.spi;

import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.response.DishResponseDto;
import com.pragma.powerup.squaremealsmicroservice.domain.model.Dish;

public interface IDishPersistencePort {
    DishResponseDto saveDish(Dish dish);
}