package com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.request;

import com.pragma.powerup.squaremealsmicroservice.domain.model.Category;
import com.pragma.powerup.squaremealsmicroservice.domain.model.Restaurant;
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
    private Category category;
    private Long idRestaurant;
    private Restaurant restaurant;
    private boolean active;
}