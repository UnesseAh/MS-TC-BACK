package com.tourconnect.mctcactivity.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @ToString
public class Agency {
    private Long id;
    private String name;
    private String description;
    private String city;
    private String address;
    private String phoneNumber;
    private String email;
}
