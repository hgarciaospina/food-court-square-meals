package com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.adapter;

import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.mappers.IDishEntityMapper;
import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.repositories.IDishRepository;
import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.response.DishResponseDto;
import com.pragma.powerup.squaremealsmicroservice.domain.model.Dish;
import com.pragma.powerup.squaremealsmicroservice.domain.spi.IDishPersistencePort;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DishMysqlAdapter implements IDishPersistencePort {
    private final IDishRepository dishRepository;
    private final IDishEntityMapper dishEntityMapper;

    @Override
    public DishResponseDto saveDish(Dish dish) {
        return dishEntityMapper.responseDtoToEntity(dishRepository.save(dishEntityMapper.entityToModel(dish)));
    }
}