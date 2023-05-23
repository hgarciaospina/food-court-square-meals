package com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.response;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RestaurantResponseDto {
    private String name;
    private String tin;
    private String address;
    private Long idOwner;
    private String phone;
    private String urlLogo;
}