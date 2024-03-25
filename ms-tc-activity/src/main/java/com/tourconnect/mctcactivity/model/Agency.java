package com.tourconnect.mctcactivity.model;

import lombok.*;

@Getter @Setter @ToString @Builder @AllArgsConstructor @NoArgsConstructor
public class Agency {
    private Long id;
    private String name;
    private String description;
    private String city;
    private String address;
    private String phoneNumber;
    private String email;
}
