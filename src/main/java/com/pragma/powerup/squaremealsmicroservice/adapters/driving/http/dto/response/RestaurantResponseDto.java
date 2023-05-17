package com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.response;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class RestaurantResponseDto {
    @Pattern(regexp =  "^[a-zA-Z\\d\\s]*$")
    private String name;
    @NotEmpty
    @Size(min = 9)
    @Pattern(regexp = "[1-9]\\d{8}")
    private String tin;
    @NotEmpty
    private String address;
    private Long idOwner;

    @Pattern(regexp = "^(\\+57)?\\s?(\\d{1})?[\\s|-]?(\\d{3})?[\\s|-]?(\\d{3})[\\s|-]?(\\d{2})[\\s|-]?(\\d{2})$", message = "Number phone must be a valid number phone")
    @NotBlank(message = "Number phone is required")
    @NotNull(message = "Number phone number is required")
    private String phone;
    @Pattern(regexp = "^(https?|ftp)://([\\w.-]+)(:\\d+)?(/\\S*)?$")
    private String urlLogo;
}