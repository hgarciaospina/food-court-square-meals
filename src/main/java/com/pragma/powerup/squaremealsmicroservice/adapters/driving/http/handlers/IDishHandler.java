package com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.handlers;

import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.request.DishRequestDto;
import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.response.DishResponseDto;

public interface IDishHandler {
    DishResponseDto saveCategory(DishRequestDto dishRequestDto);
}
