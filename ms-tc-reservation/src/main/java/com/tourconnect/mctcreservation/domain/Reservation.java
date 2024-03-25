package com.tourconnect.mctcreservation.domain;

import com.tourconnect.mctcreservation.model.Activity;
import com.tourconnect.mctcreservation.model.Client;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
@Entity @Table(name = "reservations")
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Transient
    private Client client;
    private Long clientId;
    @Transient
    private Activity activity;
    private Long activityId;
    private LocalDateTime startDate;
    private LocalDateTime endDate;
    private Long totalPrice;
    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime updatedDate;
}
