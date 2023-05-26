package com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.response;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryResponseDto {
    private String name;
    private String description;
}