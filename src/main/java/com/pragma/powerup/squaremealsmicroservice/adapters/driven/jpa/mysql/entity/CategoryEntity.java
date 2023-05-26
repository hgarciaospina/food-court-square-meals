package com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.entity;

import com.pragma.powerup.squaremealsmicroservice.domain.model.Dish;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "category")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Dish> dishes;

    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;
}