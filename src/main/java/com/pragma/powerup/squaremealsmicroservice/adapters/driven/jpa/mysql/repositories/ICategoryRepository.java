package com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.repositories;

import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<CategoryEntity, Long> {
    boolean existsByName(String name);
}
