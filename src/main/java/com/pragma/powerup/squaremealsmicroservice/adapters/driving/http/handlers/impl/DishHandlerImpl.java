package com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.handlers.impl;

import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.exceptions.RestaurantNameAlreadyExistsException;
import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.exceptions.RestaurantNotFoundException;
import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.repositories.ICategoryRepository;
import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.repositories.IRestaurantRepository;
import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.request.DishRequestDto;
import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.response.DishResponseDto;
import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.handlers.IDishHandler;
import com.pragma.powerup.squaremealsmicroservice.domain.api.IDishServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DishHandlerImpl implements IDishHandler {
    private final IDishServicePort dishServicePort;
    private final IRestaurantRepository restaurantRepository;
    private final ICategoryRepository categoryRepository;

    @Override
    public DishResponseDto saveDish(DishRequestDto dishRequestDto) {
        if(!restaurantRepository.findById(dishRequestDto.getIdRestaurant()).isPresent()){
          throw new RestaurantNotFoundException();
        }

        if(!categoryRepository.findById(dishRequestDto.getIdCategory()).isPresent()){
            throw new RestaurantNameAlreadyExistsException();
        }

        if(!restaurantRepository.findById(dishRequestDto.getIdRestaurant()).isPresent()){
            throw new RestaurantNotFoundException();
        }
        return dishServicePort.saveDish(dishRequestDto);
    }
}