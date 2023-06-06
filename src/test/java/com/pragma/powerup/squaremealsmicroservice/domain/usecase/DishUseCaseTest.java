package com.pragma.powerup.squaremealsmicroservice.domain.usecase;

import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.mappers.IDishEntityMapper;
import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.request.DishRequestDto;
import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.response.DishResponseDto;
import com.pragma.powerup.squaremealsmicroservice.domain.exceptions.*;
import com.pragma.powerup.squaremealsmicroservice.domain.model.Category;
import com.pragma.powerup.squaremealsmicroservice.domain.model.Restaurant;
import com.pragma.powerup.squaremealsmicroservice.domain.spi.IDishPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
class DishUseCaseTest {
    @Mock
    private IDishPersistencePort dishPersistencePort;
    @Mock
    private IDishEntityMapper dishEntityMapper;

    @InjectMocks
    private DishUseCase dishUseCase;

    @BeforeEach
    void setup() {
        dishUseCase = new DishUseCase(dishPersistencePort, dishEntityMapper);
    }

    @Test
    void testSaveDish_ValidData_Successful() {
        Category category1 = Category.builder()
                .id(1L)
                .name("Main dish")
                .description("Main dish")
                .build();

        Restaurant restaurant1 = Restaurant.builder()
                        .id(1L)
                        .name("The Buffalo")
                        .tin("910101101")
                        .phone("++573104567878")
                        .address("Old West Street")
                        .urlLogo("https://img.lalr.co/cms/2020/12/03171752/LOCACIONES-DESCORTES-NOV-2020-1.jpg?size=xl")
                        .idOwner(5L)
                        .build();

        DishRequestDto dishRequestDto = DishRequestDto.builder()
                .name("Fish Red")
                .description("Fish Red")
                .price(15)
                .idCategory(1L)
                .category(category1)
                .restaurant(restaurant1)
                .urlImage("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTyVJDiNz5dYwGWaYxtuA_VCci4DiSslDeAETfDH0JUdQ&s")
                .active(true)
                .build();

        Mockito.when(dishPersistencePort.saveDish(any())).thenReturn(new DishResponseDto());
        DishResponseDto response = dishUseCase.saveDish(dishRequestDto);
        assertNotNull(response);
        Mockito.verify(dishPersistencePort,times(1)).saveDish(any());
    }

    @Test
    void testSaveDish_InvalidName_ThrowsDishNameInvalidException() {
        DishRequestDto dishRequestDto = new DishRequestDto();
        dishRequestDto.setName("1111");
        dishRequestDto.setDescription("Description");
        dishRequestDto.setPrice(10);
        assertThrows(DishNameInvalidException.class, () -> dishUseCase.saveDish(dishRequestDto));
    }

    @Test
    void testSaveDish_InvalidDescription_ThrowsDishDescriptionInvalidException() {
        DishRequestDto dishRequestDto = new DishRequestDto();
        dishRequestDto.setName("Fish Blue");
        dishRequestDto.setDescription("");
        dishRequestDto.setPrice(10);
        assertThrows(DishDescriptionInvalidException.class, () -> dishUseCase.saveDish(dishRequestDto));
    }

    @Test
    void testSaveDish_InvalidPrice_ThrowsDishPriceInvalidException() {
        DishRequestDto dishRequestDto = new DishRequestDto();
        dishRequestDto.setName("Fish Blue");
        dishRequestDto.setDescription("Valid Description");
        dishRequestDto.setPrice(-10);
        assertThrows(DishPriceInvalidException.class, () -> dishUseCase.saveDish(dishRequestDto));
    }

    @Test
    void testIsValidDescription_NullDescription_ReturnsFalse() {
        boolean isValid = dishUseCase.hasValidDescription(null);
        assertFalse(isValid);
    }

    @Test
    void testIsValidName_NullName_ReturnsFalse() {
        boolean isValid = dishUseCase.hasValidName(null);
        assertFalse(isValid);
    }

    @Test
    void testIsValidDescription_EmptyDescription_ReturnsFalse() {
        boolean isValid = dishUseCase.hasValidDescription(null);
        assertFalse(isValid);
    }

    @Test
    void testIsValidName_EmptyName_ReturnsFalse() {
        boolean isValid = dishUseCase.hasValidName("");
        assertFalse(isValid);
    }

    @Test
    void testIsValidDescription_BlankDescription_ReturnsFalse() {
        boolean isValid = dishUseCase.hasValidDescription("    ");
        assertFalse(isValid);
    }

    @Test
    void testIsValidName_BlankName_ReturnsFalse() {
        boolean isValid = dishUseCase.hasValidName("  ");
        assertFalse(isValid);
    }

    @Test
    void testIsValidPrice_GreaterThanZero_ReturnsFalse() {
        DishRequestDto dishRequestDto = new DishRequestDto();
        dishRequestDto.setPrice(-10);
        boolean isValid = dishUseCase.isValidPrice(dishRequestDto);
        assertFalse(isValid);
    }
}