package com.tourconnect.mctcactivity.dto;

import com.tourconnect.mctcactivity.domain.Activity;

public record ActivityResponseDTO(
        String name,
        String about,
        Double price,
        String duration,
//        Agency agency,
        Long agencyId
) {
    public static ActivityResponseDTO toDTO(Activity activity){
        return new ActivityResponseDTO(
                activity.getName(),
                activity.getAbout(),
                activity.getPrice(),
                activity.getDuration(),
                activity.getAgencyId()
        );
    }
}
