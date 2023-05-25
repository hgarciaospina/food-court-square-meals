package com.pragma.powerup.squaremealsmicroservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Dish {
    private Long id;
    private String name;
    private String description;
    private int price;
    private String urlImage;
    private Long idCategory;
    private Long idRestaurant;
    private boolean active;
}
