package com.pragma.powerup.squaremealsmicroservice.domain.usecase;

import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.mappers.ICategoryEntityMapper;
import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.request.CategoryRequestDto;
import com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.response.CategoryResponseDto;
import com.pragma.powerup.squaremealsmicroservice.domain.exceptions.CategoryDescriptionInvalidException;
import com.pragma.powerup.squaremealsmicroservice.domain.exceptions.CategoryNameInvalidException;
import com.pragma.powerup.squaremealsmicroservice.domain.model.Category;
import com.pragma.powerup.squaremealsmicroservice.domain.spi.ICategoryPersistencePort;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


@ExtendWith(MockitoExtension.class)
class CategoryUseCaseTest {

    @Mock
    private ICategoryPersistencePort mockCategoryPersistencePort;

    @Mock
    private ICategoryEntityMapper mockCategoryEntityMapper;

    @InjectMocks
    private CategoryUseCase categoryUseCase;

    @BeforeEach
    public void setUp() {
        categoryUseCase = new CategoryUseCase(mockCategoryPersistencePort, mockCategoryEntityMapper);
    }

    @Test
    void testSaveCategory_ValidData_Success() {
        CategoryRequestDto requestDto = new CategoryRequestDto();
        requestDto.setName("Valid Name");
        requestDto.setDescription("Valid Description");

        Category category = new Category();
        when(mockCategoryEntityMapper.requestDtoToModel(requestDto)).thenReturn(category);
        when(mockCategoryPersistencePort.saveCategory(category)).thenReturn(new CategoryResponseDto());

        CategoryResponseDto responseDto = categoryUseCase.saveCategory(requestDto);

        assertNotNull(responseDto);
    }

    @Test
    void testSaveCategory_InvalidName_ThrowsException() {
        CategoryRequestDto requestDto = new CategoryRequestDto();
        requestDto.setName("1234");
        requestDto.setDescription("Valid Description");

        assertThrows(CategoryNameInvalidException.class, () -> {
            categoryUseCase.saveCategory(requestDto);
        });
    }

    @Test
    void testSaveCategory_InvalidDescription_ThrowsException() {
        // Arrange
        CategoryRequestDto requestDto = new CategoryRequestDto();
        requestDto.setName("Valid Name");
        requestDto.setDescription("1234");

        assertThrows(CategoryDescriptionInvalidException.class, () -> {
            categoryUseCase.saveCategory(requestDto);
        });
    }
}