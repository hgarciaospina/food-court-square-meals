package com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.entity;

import com.pragma.powerup.squaremealsmicroservice.domain.model.Dish;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Table(name = "restaurant")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RestaurantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "restaurant", cascade = CascadeType.ALL)
    private List<Dish> dishes;
    private String name;
    @Column(name = "tin", unique = true, nullable = false, length = 9)
    private String tin;
    private String address;
    @Column(name = "id_owner", nullable = false)
    private Long idUser;
    @Column(nullable = false, length = 13)
    private String phone;
    private String urlLogo;
}