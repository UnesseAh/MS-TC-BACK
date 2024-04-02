package com.tourconnect.mctcagency.dto;

import com.tourconnect.mctcagency.domain.Agency;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record AgencyRequestDTO(
        @NotBlank(message = "Name is required")
        @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
        String name,
        @NotBlank(message = "Description is required")
        @Size(min = 2, max = 50, message = "Description must be between 2 and 5000 characters")
        String description,
        @NotBlank(message = "City is required")
        @Size(min = 2, max = 50, message = "City must be between 2 and 50 characters")
        String city,
        @NotBlank(message = "Address is required")
        @Size(min = 2, max = 50, message = "Address must be between 2 and 300 characters")
        String address,
        @Pattern(regexp = "^$|^[0-9]{10}$", message = "Phone number must be a 10-digit number or empty")
        String phoneNumber,
        @Email(message = "Invalid email format")
        String email
) {
    public Agency toEntity(){
        return Agency.builder()
                .name(name)
                .description(description)
                .city(city)
                .address(address)
                .phoneNumber(phoneNumber)
                .email(email)
                .build();
    }
}
