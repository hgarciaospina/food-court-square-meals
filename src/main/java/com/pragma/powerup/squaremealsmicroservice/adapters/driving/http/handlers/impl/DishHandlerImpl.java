package com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.handlers.impl;

import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.entity.CategoryEntity;
import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.entity.RestaurantEntity;
import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.exceptions.CategoryNotFoundException;
import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.exceptions.RestaurantNotFoundException;
import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.repositories.ICategoryRepository;
import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.repositories.IRestaurantRepository;
import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.request.DishRequestDto;
import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.response.DishResponseDto;
import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.handlers.IDishHandler;
import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.mapper.ICategoryRequestMapper;

import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.mapper.IRestaurantRequestMapper;
import com.pragma.powerup.squaremealsmicroservice.domain.api.IDishServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class DishHandlerImpl implements IDishHandler {
    private final IDishServicePort dishServicePort;
    private final IRestaurantRepository restaurantRepository;
    private final IRestaurantRequestMapper restaurantRequestMapper;
    private final ICategoryRepository categoryRepository;
    private final ICategoryRequestMapper categoryRequestMapper;

    @Override
    public DishResponseDto saveDish(DishRequestDto dishRequestDto) {
        RestaurantEntity restaurantEntity = restaurantRepository.findById(dishRequestDto.getIdRestaurant())
                .orElseThrow(RestaurantNotFoundException::new);

        CategoryEntity categoryEntity = categoryRepository.findById(dishRequestDto.getIdCategory())
                .orElseThrow(CategoryNotFoundException::new);

        dishRequestDto.setRestaurant(restaurantRequestMapper.entityToModel(restaurantEntity));
        dishRequestDto.setCategory(categoryRequestMapper.entityToModel(categoryEntity));

        return dishServicePort.saveDish(dishRequestDto);
    }
}