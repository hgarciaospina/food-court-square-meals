package com.pragma.powerup.squaremealsmicroservice.domain.usecase;

import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.mappers.IDishEntityMapper;
import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.request.DishRequestDto;
import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.response.DishResponseDto;
import com.pragma.powerup.squaremealsmicroservice.domain.api.IDishServicePort;
import com.pragma.powerup.squaremealsmicroservice.domain.exceptions.*;
import com.pragma.powerup.squaremealsmicroservice.domain.spi.IDishPersistencePort;
import lombok.RequiredArgsConstructor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.pragma.powerup.squaremealsmicroservice.configuration.Constants.*;

@RequiredArgsConstructor
public class DishUseCase implements IDishServicePort {
    private final IDishPersistencePort dishPersistencePort;
    private final IDishEntityMapper dishEntityMapper;
    @Override
    public DishResponseDto saveDish(DishRequestDto dishRequestDto) {
        if (!hasValidName(dishRequestDto.getName()))
            throw new DishNameInvalidException();

        if (!hasValidDescription(dishRequestDto.getDescription()))
            throw new DishDescriptionInvalidException();

        if(!isValidPrice(dishRequestDto))
            throw  new DishPriceInvalidException();

        return dishPersistencePort.saveDish(dishEntityMapper.requestDtoToModel(dishRequestDto));
    }
    public boolean hasValidName(String name) {
        return validateValue(name, DISH_NAME_PATTERN);
    }
    public boolean hasValidDescription(String description) { return validateValue(description, DISH_DESCRIPTION_PATTERN); }
    public boolean validateValue(String value, String pattern) {
        if (value == null || value.trim().isEmpty() || value.trim().isBlank())
            return false;

        Pattern regex = Pattern.compile(pattern);
        Matcher matcher = regex.matcher(value);

        return matcher.matches();
    }
    public boolean isValidPrice (DishRequestDto dishRequestDto) {
        return dishRequestDto.getPrice() > 0;
    }
}