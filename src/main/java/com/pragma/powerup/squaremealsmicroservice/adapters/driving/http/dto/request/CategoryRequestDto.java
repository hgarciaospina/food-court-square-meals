package com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.request;

import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class CategoryRequestDto {
    private String name;
    private String description;
}