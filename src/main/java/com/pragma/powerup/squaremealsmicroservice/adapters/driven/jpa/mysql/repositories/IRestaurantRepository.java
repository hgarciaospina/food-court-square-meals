package com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.repositories;

import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.entity.RestaurantEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRestaurantRepository extends JpaRepository<RestaurantEntity, Long> {
    Optional<RestaurantEntity> findByTin(String tin);

    boolean existsByName(String name);
    boolean existsByTin(String tin);
}
