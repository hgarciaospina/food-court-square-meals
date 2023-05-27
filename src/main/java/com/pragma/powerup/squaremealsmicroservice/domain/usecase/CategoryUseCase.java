package com.pragma.powerup.squaremealsmicroservice.domain.usecase;

import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.mappers.ICategoryEntityMapper;
import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.request.CategoryRequestDto;
import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.response.CategoryResponseDto;
import com.pragma.powerup.squaremealsmicroservice.domain.api.ICategoryServicePort;
import com.pragma.powerup.squaremealsmicroservice.domain.exceptions.CategoryDescriptionInvalidException;
import com.pragma.powerup.squaremealsmicroservice.domain.exceptions.CategoryDescriptionNullEmptyBlankInvalidException;
import com.pragma.powerup.squaremealsmicroservice.domain.exceptions.CategoryNameInvalidException;
import com.pragma.powerup.squaremealsmicroservice.domain.exceptions.CategoryNameNullEmptyBlankInvalidException;
import com.pragma.powerup.squaremealsmicroservice.domain.spi.ICategoryPersistencePort;

import lombok.RequiredArgsConstructor;

import java.util.regex.Pattern;
import java.util.regex.Matcher;

import static com.pragma.powerup.squaremealsmicroservice.configuration.Constants.DESCRIPTION_PATTERN;
import static com.pragma.powerup.squaremealsmicroservice.configuration.Constants.NAME_PATTERN;

@RequiredArgsConstructor
public class CategoryUseCase implements ICategoryServicePort {
    private final ICategoryPersistencePort categoryPersistencePort;
    private final ICategoryEntityMapper categoryEntityMapper;
    @Override
    public CategoryResponseDto saveCategory(CategoryRequestDto categoryRequestDto) {

        if (!isValidName(categoryRequestDto.getName()))
            throw new CategoryNameInvalidException();

        if (!isValidDescription(categoryRequestDto.getDescription()))
            throw new CategoryDescriptionInvalidException();

        if (!isValidPattern(categoryRequestDto.getName(), NAME_PATTERN))
            throw  new CategoryNameNullEmptyBlankInvalidException();

        if(!isValidPattern(categoryRequestDto.getDescription(), DESCRIPTION_PATTERN))
            throw  new CategoryDescriptionNullEmptyBlankInvalidException();

        return categoryPersistencePort.saveCategory(categoryEntityMapper.requestDtoToModel(categoryRequestDto));
    }
    public boolean isValidName(String name) { return isValidPattern(name, NAME_PATTERN); }
    public boolean isValidDescription(String description) { return isValidPattern(description, DESCRIPTION_PATTERN); }
    public boolean isValidPattern(String value, String pattern) {
        if (value == null || value.trim().isEmpty() || value.trim().isBlank())
            return false;

        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(value);

        return matcher.matches();
    }
}