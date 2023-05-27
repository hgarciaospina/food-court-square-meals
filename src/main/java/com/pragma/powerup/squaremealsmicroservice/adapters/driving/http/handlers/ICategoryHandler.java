package com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.handlers;

import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.request.CategoryRequestDto;
import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.response.CategoryResponseDto;

public interface ICategoryHandler {
    CategoryResponseDto saveCategory(CategoryRequestDto categoryRequestDto);
}
