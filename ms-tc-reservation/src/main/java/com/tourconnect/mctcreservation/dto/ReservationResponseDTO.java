package com.tourconnect.mctcreservation.dto;

import com.tourconnect.mctcreservation.domain.Reservation;

import java.time.LocalDateTime;

public record ReservationResponseDTO(
        Long clientId,
        Long activityId,
        LocalDateTime startDate,
        LocalDateTime endDate,
        Long totalPrice
) {
    public static ReservationResponseDTO toDTO(Reservation reservation){
        return new ReservationResponseDTO(
                reservation.getClientId(),
                reservation.getActivityId(),
                reservation.getStartDate(),
                reservation.getEndDate(),
                reservation.getTotalPrice()
        );
    }
}
