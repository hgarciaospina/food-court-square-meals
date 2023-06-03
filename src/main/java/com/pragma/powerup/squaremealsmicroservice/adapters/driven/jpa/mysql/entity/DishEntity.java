package com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "dish")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class DishEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_restaurant", nullable = false)
    private RestaurantEntity restaurantEntity;

    @ManyToOne
    @JoinColumn(name = "id_category", nullable = false)
    private CategoryEntity categoryEntity;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String urlImage;

    @Column(columnDefinition = "boolean default true")
    private boolean active;
}