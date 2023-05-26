package com.pragma.powerup.squaremealsmicroservice.domain.api;

import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.request.DishRequestDto;
import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.response.DishResponseDto;

public interface IDishServicePort {
    DishResponseDto saveDish(DishRequestDto dishRequestDto);
}