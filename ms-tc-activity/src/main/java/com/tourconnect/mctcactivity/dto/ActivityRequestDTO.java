package com.tourconnect.mctcactivity.dto;

import com.tourconnect.mctcactivity.domain.Activity;
import jakarta.validation.constraints.*;

public record ActivityRequestDTO(
        @NotBlank(message = "Name is required")
        @Size(min = 2, max = 50, message = "Name must be between 2 and 50 characters")
        @Pattern(regexp="[^0-9]*$",message = "Name must only contain characters")
        String name,
        @NotBlank(message = "About is required")
        @Size(min = 2, max = 50, message = "About must be between 2 and 5000 characters")
        String about,
        @NotNull(message = "Price is required")
        @Min(value = 0, message = "Price can't be negative")
        @Digits(integer = 6, fraction = 2)
        Double price,
        @NotBlank(message = "Duration is required")
        String duration,
        @NotNull(message = "AgencyId can't be null")
        @Min(value = 0, message = "AgencyId can't be negative")
//        Agency agency,
        Long agencyId
) {
    public Activity toEntity(){
        return Activity.builder()
                .name(name)
                .about(about)
                .price(price)
                .duration(duration)
                .agencyId(agencyId)
                .build();
    }
}
