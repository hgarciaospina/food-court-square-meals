package com.pragma.powerup.squaremealsmicroservice.adapters.driving.http.dto.request;

import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.validator.constraints.URL;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class RestaurantRequestDto {
    @NotNull(message = "The name  of the restaurant is required")
    @NotBlank(message = "The name of the restaurant cannot have only blank spaces")
    @NotEmpty(message = "The restaurant name cannot be an empty string")
    @Pattern(regexp =  "^(?!\\s+$)^(?!\\d+$)[\\w\\s.#]+$", message="The name of restaurant format is invalid.")
    private String name;

    @NotBlank(message = "The Number of tin is required")
    @NotEmpty(message = "The Number of tin cannot have only blank spaces")
    @NotNull(message = "The Number of tin  tin is required")
    private String tin;

    @NotNull(message = "The address of restaurant is required")
    @NotBlank(message = "The address of restaurant cannot have only blank spaces")
    @NotEmpty(message = "The address of restaurant cannot be an empty string")
    @Pattern(regexp = "^(?!\\s+$)^(?!\\d+$)[\\w\\s.#-,]+$", message ="The address format is incorrect.")
    private String address;

    @NotNull(message = "The owner is required")
    private Long idOwner;

    @Pattern(regexp = "^(\\+57)?\\s?(\\d{1})?[\\s|-]?(\\d{3})?[\\s|-]?(\\d{3})[\\s|-]?(\\d{2})[\\s|-]?(\\d{2})$", message = "Number phone must be a valid number phone")
    @Size(max = 13, message = "The phone number must not be longer than 13")
    @NotBlank(message = "Number phone is required")
    @NotEmpty(message = "Number phone is required")
    @NotNull(message = "Number phone is required")
    private String phone;

    @Pattern(regexp = "^(https?|ftp)://([\\w.-]+)(:\\d+)?(/\\S*)?$",message="The url logo must be a format valid" )
    @URL
    private String urlLogo;
}