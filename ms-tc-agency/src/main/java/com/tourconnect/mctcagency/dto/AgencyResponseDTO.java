package com.tourconnect.mctcagency.dto;

import com.tourconnect.mctcagency.domain.Agency;

public record AgencyResponseDTO(
        String name,
        String description,
        String city,
        String address,
        String phoneNumber,
        String email
) {
    public static AgencyRequestDTO agencyRequestDTO(Agency agency){
        return new AgencyRequestDTO(
                agency.getName(),
                agency.getDescription(),
                agency.getCity(),
                agency.getAddress(),
                agency.getPhoneNumber(),
                agency.getPhoneNumber()
        );
    }
}
