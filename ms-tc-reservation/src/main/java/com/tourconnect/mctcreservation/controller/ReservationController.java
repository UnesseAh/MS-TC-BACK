package com.tourconnect.mctcreservation.controller;

import com.tourconnect.mctcreservation.domain.Reservation;
import com.tourconnect.mctcreservation.service.ReservationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public List<Reservation> getAll(){
        return reservationService.getAll();
    }

    @PostMapping
    public Reservation create(Reservation reservation) {
        return reservationService.create(reservation);
    }

    @GetMapping("/{id}")
    public Optional<Reservation> getAgency(@PathVariable Long id){
        return reservationService.findById(id);
    }
}
