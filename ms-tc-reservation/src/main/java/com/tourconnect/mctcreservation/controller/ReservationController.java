package com.tourconnect.mctcreservation.controller;

import com.tourconnect.mctcreservation.domain.Reservation;
import com.tourconnect.mctcreservation.dto.ReservationRequestDTO;
import com.tourconnect.mctcreservation.dto.ReservationResponseDTO;
import com.tourconnect.mctcreservation.handler.exception.ResourceNotFoundException;
import com.tourconnect.mctcreservation.handler.response.GenericResponse;
import com.tourconnect.mctcreservation.service.ReservationService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/reservations")
public class ReservationController {
    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<Reservation> reservations = reservationService.getAll();

        List<ReservationResponseDTO> reservationResponseDTOS = new ArrayList<>();
        reservations.forEach(reservation -> reservationResponseDTOS.add(ReservationResponseDTO.toDTO(reservation)));
        return GenericResponse.ok(
                reservationResponseDTOS,
                "Reservations retrieved successfully"
        );
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid ReservationRequestDTO reservationRequestDTO) {
        Reservation reservation = reservationService.create(reservationRequestDTO.toEntity());
        return GenericResponse.created(
                ReservationResponseDTO.toDTO(reservation),
                "Reservation created successfully"
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> get(@PathVariable Long id){
        Optional<Reservation> reservation = reservationService.findById(id);
        if (reservation.isEmpty()){
            throw new ResourceNotFoundException("Reservation with id " + id + " doesn't exist!");
        }
        ReservationResponseDTO reservationResponseDTO = ReservationResponseDTO.toDTO(reservation.get());
        return GenericResponse.ok(reservationResponseDTO, "Reservation found");
    }

}
