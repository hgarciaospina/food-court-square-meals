package com.pragma.powerup.squaremealsmicroservice.configuration;

import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.adapter.CategoryMysqlAdapter;
import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.adapter.DishMysqlAdapter;
import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.adapter.RestaurantMysqlAdapter;
import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.mappers.ICategoryEntityMapper;
import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.mappers.IDishEntityMapper;
import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.mappers.IRestaurantEntityMapper;
import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.repositories.ICategoryRepository;
import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.repositories.IDishRepository;
import com.pragma.powerup.squaremealsmicroservice.adapters.driven.jpa.mysql.repositories.IRestaurantRepository;
import com.pragma.powerup.squaremealsmicroservice.domain.api.ICategoryServicePort;
import com.pragma.powerup.squaremealsmicroservice.domain.api.IDishServicePort;
import com.pragma.powerup.squaremealsmicroservice.domain.api.IRestaurantServicePort;
import com.pragma.powerup.squaremealsmicroservice.domain.spi.ICategoryPersistencePort;
import com.pragma.powerup.squaremealsmicroservice.domain.spi.IDishPersistencePort;
import com.pragma.powerup.squaremealsmicroservice.domain.spi.IRestaurantPersistencePort;
import com.pragma.powerup.squaremealsmicroservice.domain.usecase.CategoryUseCase;
import com.pragma.powerup.squaremealsmicroservice.domain.usecase.DishUseCase;
import com.pragma.powerup.squaremealsmicroservice.domain.usecase.RestaurantUseCase;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {
    private final IRestaurantRepository restaurantRepository;
    private final IRestaurantEntityMapper restaurantEntityMapper;
    private final ICategoryRepository categoryRepository;
    private final ICategoryEntityMapper categoryEntityMapper;
    private final IDishRepository dishRepository;
    private final IDishEntityMapper dishEntityMapper;
    @Bean
    public IRestaurantPersistencePort restaurantPersistencePort() {
        return new RestaurantMysqlAdapter(restaurantRepository, restaurantEntityMapper);
    }
    @Bean
    public IRestaurantServicePort restaurantServicePort() {
        return new RestaurantUseCase(restaurantPersistencePort(), restaurantEntityMapper);
    }

    @Bean
    public ICategoryPersistencePort categoryPersistencePort() {
        return new CategoryMysqlAdapter(categoryRepository, categoryEntityMapper);
    }
    @Bean
    public ICategoryServicePort categoryServicePort() {
        return new CategoryUseCase(categoryPersistencePort(), categoryEntityMapper);
    }
    @Bean
    public IDishPersistencePort dishPersistencePort() {
        return new DishMysqlAdapter(dishRepository, dishEntityMapper);
    }
    @Bean
    public IDishServicePort dishServicePort() {
        return new DishUseCase(dishPersistencePort(), dishEntityMapper);
    }
}