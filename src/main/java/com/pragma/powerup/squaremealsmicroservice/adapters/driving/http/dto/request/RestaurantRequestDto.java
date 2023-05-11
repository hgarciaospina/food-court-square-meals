package com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class RestaurantRequestDto {
    private String name;
    private String tin;
    private String address;
    private Long idOwner;
    private String phone;
    private String urlLogo;
}