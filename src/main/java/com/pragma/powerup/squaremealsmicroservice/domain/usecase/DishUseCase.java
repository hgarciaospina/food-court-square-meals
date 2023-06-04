package com.pragma.powerup.squaremealsmicroservice.domain.usecase;

import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.mappers.IDishEntityMapper;
import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.request.DishRequestDto;
import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.response.DishResponseDto;
import com.pragma.powerup.squaremealsmicroservice.domain.api.IDishServicePort;
import com.pragma.powerup.squaremealsmicroservice.domain.spi.IDishPersistencePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DishUseCase implements IDishServicePort {
    private final IDishPersistencePort dishPersistencePort;
    private final IDishEntityMapper dishEntityMapper;
    @Override
    public DishResponseDto saveDish(DishRequestDto dishRequestDto) {

        if(dishRequestDto.getUrlImage().isBlank() || dishRequestDto.getUrlImage().isEmpty())
            return null;
        return dishPersistencePort.saveDish(dishEntityMapper.requestDtoToModel(dishRequestDto));
    }

}