package com.pragma.powerup.squaremealsmicroservice.domain.model;

import lombok.*;

@Builder
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
    private Category category;
    private Restaurant restaurant;
    private boolean active;
}
