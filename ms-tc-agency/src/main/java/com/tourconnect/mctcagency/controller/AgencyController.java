package com.tourconnect.mctcagency.controller;

import com.tourconnect.mctcagency.domain.Agency;
import com.tourconnect.mctcagency.dto.AgencyRequestDTO;
import com.tourconnect.mctcagency.dto.AgencyResponseDTO;
import com.tourconnect.mctcagency.service.interfaces.AgencyService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/agencies")
public class AgencyController {
    private final AgencyService agencyService;

    public AgencyController(AgencyService agencyService) {
        this.agencyService = agencyService;
    }

    @GetMapping
    public List<Agency> getAll(){
        return agencyService.getAll();
    }

    @PostMapping
    public ResponseEntity<?> createAgency(@RequestBody @Valid AgencyRequestDTO agencyRequestDTO) {
        Agency agency = agencyService.create(agencyRequestDTO.toEntity());
        return agencyService.create(agency);
    }

    @GetMapping("/{id}")
    public Optional<Agency> getAgency(@PathVariable Long id){
        return agencyService.findById(id);
    }

}
