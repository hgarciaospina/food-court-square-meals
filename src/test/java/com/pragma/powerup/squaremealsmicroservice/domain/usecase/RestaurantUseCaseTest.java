package com.pragma.powerup.squaremealsmicroservice.domain.usecase;

import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.mappers.IRestaurantEntityMapper;
import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.request.RestaurantRequestDto;
import com.pragma.powerup.squaremealsmicroservice.domain.exceptions.TinLengthInvalidException;
import com.pragma.powerup.squaremealsmicroservice.domain.spi.IRestaurantPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class RestaurantUseCaseTest {
    @Mock
    private IRestaurantPersistencePort mockRestaurantPersistencePort;
    @Mock
    private IRestaurantEntityMapper mockRestaurantEntityMapper;

    private RestaurantUseCase restaurantUseCase;

    @BeforeEach
    void setup() {
        restaurantUseCase = new RestaurantUseCase(mockRestaurantPersistencePort, mockRestaurantEntityMapper);
    }

    @Test
    void saveRestaurant_ValidTinNumber_CallsPersistencePortSaveRestaurant() {
        RestaurantRequestDto requestDto = new RestaurantRequestDto();
        requestDto.setTin("123456789");

        when(mockRestaurantEntityMapper.requestDtoToModel(requestDto)).thenReturn(any());

        restaurantUseCase.saveRestaurant(requestDto);

        verify(mockRestaurantPersistencePort, times(1)).saveRestaurant(any());
    }

    @Test
    void saveRestaurant_InvalidTinNumber_ThrowsException() {
        RestaurantRequestDto requestDto = new RestaurantRequestDto();
        requestDto.setTin("123");

        assertThrows(TinLengthInvalidException.class, () -> restaurantUseCase.saveRestaurant(requestDto));
    }
}