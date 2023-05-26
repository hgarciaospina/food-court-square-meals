package com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.repositories;

import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.entity.DishEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDishRepository extends JpaRepository<DishEntity, Long> {
    boolean existsByName(String name);
}