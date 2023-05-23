package com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.request;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
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