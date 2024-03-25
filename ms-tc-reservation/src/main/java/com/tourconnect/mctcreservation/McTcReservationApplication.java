package com.tourconnect.mctcreservation;

import com.tourconnect.mctcreservation.domain.Reservation;
import com.tourconnect.mctcreservation.repository.ReservationRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.time.LocalDateTime;
import java.util.List;

@EnableJpaAuditing
@SpringBootApplication
public class McTcReservationApplication {

    public static void main(String[] args) {
        SpringApplication.run(McTcReservationApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ReservationRepository reservationRepository){
        return args -> {
            List<Reservation> reservations = List.of(
                    Reservation.builder()
                            .clientId(1L)
                            .activityId(1L)
                            .startDate(LocalDateTime.now())
                            .endDate(LocalDateTime.now())
                            .totalPrice(15L)
                            .build(),
                    Reservation.builder()
                            .clientId(2L)
                            .activityId(1L)
                            .startDate(LocalDateTime.now())
                            .endDate(LocalDateTime.now())
                            .totalPrice(15L)
                            .build(),
                    Reservation.builder()
                            .clientId(3L)
                            .activityId(1L)
                            .startDate(LocalDateTime.now())
                            .endDate(LocalDateTime.now())
                            .totalPrice(15L)
                            .build(),
                    Reservation.builder()
                            .clientId(4L)
                            .activityId(1L)
                            .startDate(LocalDateTime.now())
                            .endDate(LocalDateTime.now())
                            .totalPrice(15L)
                            .build()
            );

            reservationRepository.saveAll(reservations);
        };
    }

}
