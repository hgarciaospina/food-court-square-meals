package com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.mappers;

import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.entity.CategoryEntity;
import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.request.CategoryRequestDto;
import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.response.CategoryResponseDto;
import com.pragma.powerup.squaremealsmicroservice.domain.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface ICategoryEntityMapper {
    CategoryEntity entityToModel(Category category);
    Category modelToEntity(CategoryEntity categoryEntity);
    CategoryResponseDto responseDtoToEntity(CategoryEntity categoryEntity);
    Category requestDtoToModel(CategoryRequestDto categoryRequestDto);
}
