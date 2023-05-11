package com.pragma.powerup.squaremealsmicroservice.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Restaurant {
    private Long id;
    private String name;
    private String tin;
    private String address;
    private Long idOwner;
    private String phone;
    private String urlLogo;
}
