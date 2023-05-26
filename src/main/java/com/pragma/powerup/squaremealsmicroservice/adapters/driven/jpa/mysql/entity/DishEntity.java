package com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.entity;

import com.pragma.powerup.squaremealsmicroservice.domain.model.Category;
import com.pragma.powerup.squaremealsmicroservice.domain.model.Restaurant;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "dish")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class DishEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "id_restaurant", nullable = false)
    private Restaurant restaurant;

    @ManyToOne
    @JoinColumn(name = "id_category", nullable = false)
    private Category category;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    private int price;

    @Column(nullable = false)
    private String urlImage;

    @Column(nullable = false)
    private Long idCategory;

    @Column(nullable = false)
    private Long idRestaurant;

    @Column(columnDefinition = "boolean default true")
    private boolean active;
}