package com.pragma.powerup.squaremealsmicroservice.domain.model;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Category {
    private Long id;
    private String name;
    private String description;
}
