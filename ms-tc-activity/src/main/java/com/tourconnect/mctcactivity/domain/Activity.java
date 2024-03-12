package com.tourconnect.mctcactivity.domain;

import com.tourconnect.mctcactivity.model.Agency;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@EntityListeners(AuditingEntityListener.class)
@Getter @Setter @AllArgsConstructor @NoArgsConstructor @Builder
@Entity @Table(name = "activities")
public class Activity {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String about;
    private Double price;
    private String duration;
    @Transient
    private Agency agency;
    private Long agencyId;
    @CreatedDate
    private LocalDateTime createdDate;
    @LastModifiedDate
    private LocalDateTime updatedDate;
}
