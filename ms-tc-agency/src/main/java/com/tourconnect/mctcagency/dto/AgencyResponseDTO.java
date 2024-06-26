package com.tourconnect.mctcagency.dto;

import com.tourconnect.mctcagency.domain.Agency;

public record AgencyResponseDTO(
        Long id,
        String name,
        String description,
        String city,
        String address,
        String phoneNumber,
        String email
) {
    public static AgencyResponseDTO toDTO(Agency agency){
        return new AgencyResponseDTO(
                agency.getId(),
                agency.getName(),
                agency.getDescription(),
                agency.getCity(),
                agency.getAddress(),
                agency.getPhoneNumber(),
                agency.getEmail()
        );
    }
}
