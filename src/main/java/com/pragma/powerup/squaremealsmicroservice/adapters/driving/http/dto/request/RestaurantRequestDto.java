package com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RestaurantRequestDto {
    @Pattern(regexp =  "^[a-zA-Z\\d\\s]*$")
    private String name;

    private String tin;
    private String address;
    @NotBlank(message = "The owner is required")
    @NotNull(message = "The owner is required")
    private Long idOwner;

    @Pattern(regexp = "^(\\+57)?\\s?(\\d{1})?[\\s|-]?(\\d{3})?[\\s|-]?(\\d{3})[\\s|-]?(\\d{2})[\\s|-]?(\\d{2})$", message = "Number phone must be a valid number phone")
    @NotBlank(message = "Number phone is required")
    @NotNull(message = "Number phone number is required")
    private String phone;

    @Pattern(regexp = "^(https?|ftp)://([\\w.-]+)(:\\d+)?(/\\S*)?$",message="The url logo must be a format valid" )
    private String urlLogo;
}