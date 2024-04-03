package com.tourconnect.mctcreservation.dto;

import com.tourconnect.mctcreservation.domain.Reservation;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record ReservationRequestDTO(
        @NotNull(message = "Client id can't be null")
        @Min(value = 0, message = "Client id can't be negative")
        Long clientId,
        @NotNull(message = "Activity id can't be null")
        @Min(value = 0, message = "Activity id can't be negative")
        Long activityId,
        @NotNull(message = "Start date can't be null")
        LocalDateTime startDate,
        @NotNull(message = "Start date can't be null")
        LocalDateTime endDate,
        @NotNull(message = "Price is required")
        @Min(value = 0, message = "Price can't be negative")
        @Digits(integer = 6, fraction = 2)
        Long totalPrice
) {
    public Reservation toEntity(){
        return Reservation.builder()
                .clientId(clientId)
                .activityId(activityId)
                .startDate(startDate)
                .endDate(endDate)
                .totalPrice(totalPrice)
                .build();
    }
}
