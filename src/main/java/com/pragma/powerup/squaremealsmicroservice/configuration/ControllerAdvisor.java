package com.pragma.powerup.squaremealsmicroservice.configuration;

import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.exceptions.*;
import com.pragma.powerup.squaremealsmicroservice.domain.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static com.pragma.powerup.squaremealsmicroservice.configuration.Constants.*;

@ControllerAdvice
public class ControllerAdvisor {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationException(MethodArgumentNotValidException ex) {
        List<String> errorMessages = new ArrayList<>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            if (error instanceof FieldError fieldError) {
                errorMessages.add(fieldError.getField() + ": " + fieldError.getDefaultMessage());
            } else {
                errorMessages.add(error.getDefaultMessage());
            }
        }
        return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(TinAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleRestaurantAlreadyExistsException(
            TinAlreadyExistsException restaurantAlreadyExistsException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, TIN_ALREADY_EXISTS_MESSAGE));
    }

    @ExceptionHandler(TinLengthInvalidException.class)
    public ResponseEntity<Map<String, String>> handleTinLengthInvalidException(
            TinLengthInvalidException tinLengthInvalidException) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, TIN_LENGTH_INVALID_MESSAGE));
    }

    @ExceptionHandler(RestaurantNameAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleRestaurantNameAlreadyExistsException(
            RestaurantNameAlreadyExistsException restaurantAlreadyExistsException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, RESTAURANT_NAME_ALREADY_EXISTS_MESSAGE));
    }

    @ExceptionHandler(RestaurantNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleRestaurantNotFoundException(
            RestaurantNotFoundException restaurantNotFoundException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, RESTAURANT_NOT_FOUND_MESSAGE));
    }

    @ExceptionHandler(OwnerNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleOwnerNotFoundException(
            OwnerNotFoundException ownerNotFoundException) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, OWNER_NOT_FOUND_MESSAGE));
    }
    @ExceptionHandler(OwnerAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleUserAlreadyExistsException(
            OwnerAlreadyExistsException ownerAlreadyExistsException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, OWNER_ALREADY_EXISTS_MESSAGE));
    }

    @ExceptionHandler(OwnerIsNotException.class)
    public ResponseEntity<Map<String, String>> handleOwnerIsNotException(
            OwnerIsNotException ownerIsNotException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, OWNER_IS_NOT_MESSAGE));
    }

    @ExceptionHandler(CategoryNameAlreadyExistsException.class)
    public ResponseEntity<Map<String, String>> handleCategoryNameAlreadyExistsException(
            CategoryNameAlreadyExistsException categoryNameAlreadyExistsException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, CATEGORY_NAME_ALREADY_EXISTS_MESSAGE));
    }
    @ExceptionHandler(CategoryNameInvalidException.class)
    public ResponseEntity<Map<String, String>> handleCategoryNameInvalidException(
            CategoryNameInvalidException categoryNameInvalidException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, CATEGORY_NAME_INVALID_MESSAGE));
    }
    @ExceptionHandler(CategoryDescriptionInvalidException.class)
    public ResponseEntity<Map<String, String>> handleCategoryDescriptionInvalidException(
            CategoryDescriptionInvalidException categoryDescriptionInvalidException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, CATEGORY_DESCRIPTION_INVALID_MESSAGE));
    }
    @ExceptionHandler(CategoryNameNullEmptyBlankInvalidException.class)
    public ResponseEntity<Map<String, String>> handleCategoryNameNullEmptyBlankInvalidException(
            CategoryNameInvalidException categoryNameNullEmptyBlankInvalidException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, CATEGORY_NAME_NULL_EMPTY_BLANK_INVALID_MESSAGE));
    }
    @ExceptionHandler(CategoryDescriptionNullEmptyBlankInvalidException.class)
    public ResponseEntity<Map<String, String>> handleCategoryDescriptionNullEmptyBlankInvalidException(
            CategoryDescriptionInvalidException categoryDescriptionNullEmptyBlankInvalidException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, CATEGORY_DESCRIPTION_NULL_EMPTY_BLANK_INVALID_MESSAGE));
    }

    @ExceptionHandler(CategoryNotFoundException.class)
    public ResponseEntity<Map<String, String>> handleCategoryNotFoundException(
            CategoryNotFoundException categoryNotFoundException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, CATEGORY_NOT_FOUND_MESSAGE));
    }

    @ExceptionHandler(DishNameNullEmptyBlankInvalidException.class)
    public ResponseEntity<Map<String, String>> handleDishNameNullEmptyBlankInvalidException(
            DishNameInvalidException dishNameNullEmptyBlankInvalidException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, DISH_NAME_NULL_EMPTY_BLANK_INVALID_MESSAGE));
    }
    @ExceptionHandler(DishDescriptionNullEmptyBlankInvalidException.class)
    public ResponseEntity<Map<String, String>> handleDishDescriptionNullEmptyBlankInvalidException(
            DishDescriptionInvalidException dishDescriptionNullEmptyBlankInvalidException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, DISH_DESCRIPTION_NULL_EMPTY_BLANK_INVALID_MESSAGE));
    }

    @ExceptionHandler(DishNameInvalidException.class)
    public ResponseEntity<Map<String, String>> handleDishNameInvalidException(
            DishNameInvalidException dishNameInvalidException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, DISH_NAME_INVALID_MESSAGE));
    }
    @ExceptionHandler(DishDescriptionInvalidException.class)
    public ResponseEntity<Map<String, String>> handleDishDescriptionInvalidException(
            DishDescriptionInvalidException dishDescriptionInvalidException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, DISH_DESCRIPTION_INVALID_MESSAGE));
    }

    @ExceptionHandler(DishPriceInvalidException.class)
    public ResponseEntity<Map<String, String>> handleDishPriceInvalidException(
            DishPriceInvalidException dishPriceInvalidException) {
        return ResponseEntity.status(HttpStatus.CONFLICT)
                .body(Collections.singletonMap(RESPONSE_ERROR_MESSAGE_KEY, DISH_PRICE_INVALID_MESSAGE));
    }
}