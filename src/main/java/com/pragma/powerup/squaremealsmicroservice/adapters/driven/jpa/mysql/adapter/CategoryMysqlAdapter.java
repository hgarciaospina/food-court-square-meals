package com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.adapter;

import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.exceptions.CategoryNameAlreadyExistsException;
import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.mappers.ICategoryEntityMapper;
import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.repositories.ICategoryRepository;
import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.response.CategoryResponseDto;
import com.pragma.powerup.squaremealsmicroservice.domain.model.Category;
import com.pragma.powerup.squaremealsmicroservice.domain.spi.ICategoryPersistencePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class CategoryMysqlAdapter implements ICategoryPersistencePort {
    private final ICategoryRepository categoryRepository;
    private final ICategoryEntityMapper categoryEntityMapper;

    @Override
    public CategoryResponseDto saveCategory(Category category) {
        if (categoryRepository.existsByName(category.getName())){
            throw new CategoryNameAlreadyExistsException();
        }
        return categoryEntityMapper.responseDtoToEntity(categoryRepository.save(categoryEntityMapper.entityToModel(category)));
    }
}