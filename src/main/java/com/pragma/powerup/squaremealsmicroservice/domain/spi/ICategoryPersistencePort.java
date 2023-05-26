package com.pragma.powerup.squaremealsmicroservice.domain.spi;

import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.response.CategoryResponseDto;
import com.pragma.powerup.squaremealsmicroservice.domain.model.Category;

public interface ICategoryPersistencePort {
    CategoryResponseDto saveCategory(Category category);
}
