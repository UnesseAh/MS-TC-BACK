package com.tourconnect.mctcreservation.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Activity {
    private Long id;
    private String name;
    private String about;
    private Double price;
    private String duration;
    private Long agencyId;
}
