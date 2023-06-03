package com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "category")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CategoryEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "categoryEntity", cascade = CascadeType.ALL)
    private List<DishEntity> dishEntities;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;
}