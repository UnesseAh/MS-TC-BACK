package com.tourconnect.mctcreservation.service;

import com.tourconnect.mctcreservation.domain.Reservation;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface ReservationService {
    List<Reservation> getAll();
    Reservation create(Reservation reservation);
    Optional<Reservation> findById(Long id);
}
