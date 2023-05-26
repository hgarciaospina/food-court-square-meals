package com.pragma.powerup.squaremealsmicroservice.domain.api;

import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.request.CategoryRequestDto;
import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.response.CategoryResponseDto;

public interface ICategoryServicePort {
    CategoryResponseDto saveCategory(CategoryRequestDto categoryRequestDto);
}