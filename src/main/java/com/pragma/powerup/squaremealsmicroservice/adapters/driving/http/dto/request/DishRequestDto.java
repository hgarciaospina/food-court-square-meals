package com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.request;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DishRequestDto {
    private String name;
    private String description;
    private int price;
    private String urlImage;
    private Long idCategory;
    private Long idRestaurant;
    private boolean active;
}