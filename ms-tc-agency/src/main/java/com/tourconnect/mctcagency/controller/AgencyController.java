package com.tourconnect.mctcagency.controller;

import com.tourconnect.mctcagency.domain.Agency;
import com.tourconnect.mctcagency.dto.AgencyRequestDTO;
import com.tourconnect.mctcagency.dto.AgencyResponseDTO;
import com.tourconnect.mctcagency.handler.exception.ResourceNotFoundException;
import com.tourconnect.mctcagency.handler.response.GenericResponse;
import com.tourconnect.mctcagency.service.interfaces.AgencyService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
//import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
//    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<?> getAll(){
        List<Agency> agencies = agencyService.getAll();
        if (agencies.isEmpty()){
            return GenericResponse.notFound("No agencies were found");
        }
        List<AgencyResponseDTO> agencyResponseDTOS = new ArrayList<>();
        agencies.forEach(agency -> agencyResponseDTOS.add(AgencyResponseDTO.toDTO(agency)));
        return GenericResponse.ok(
                agencyResponseDTOS,
                "Agencies returned successfully");
    }

    @PostMapping
//    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<?> create(@RequestBody @Valid AgencyRequestDTO agencyRequestDTO) {
        Agency agency = agencyService.create(agencyRequestDTO.toEntity());
        return GenericResponse.created(
                AgencyResponseDTO.toDTO(agency),
                "Agency created successfully!"
        );
    }

    @GetMapping("/{id}")
//    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<?> get(@PathVariable Long id){
        Optional<Agency> agency = agencyService.findById(id);
        if(agency.isEmpty()){
            throw new ResourceNotFoundException("Agency with id " + id + " doesn't exist!");
        }
        AgencyResponseDTO agencyResponseDTO = AgencyResponseDTO.toDTO(agency.get());
        return GenericResponse.ok(
                agencyResponseDTO,
                "Agency found"
        );
    }

    @DeleteMapping("{id}")
//    @PreAuthorize("hasAnyAuthority('ADMIN')")
    public ResponseEntity<?> delete(@PathVariable Long id){
        agencyService.delete(id);
        return GenericResponse.deleted(
                "Agency deleted successfully"
        );
    }

}
