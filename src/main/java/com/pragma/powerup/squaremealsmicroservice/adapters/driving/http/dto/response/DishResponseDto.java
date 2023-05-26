package com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.response;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DishResponseDto {
    private String name;
    private String description;
    private int price;
    private String urlImage;
    private String nameCategory;
    private String nameRestaurant;
    private boolean active;
}