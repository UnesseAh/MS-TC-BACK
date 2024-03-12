package com.tourconnect.mctcagency.controller;

import com.tourconnect.mctcagency.domain.Agency;
import com.tourconnect.mctcagency.service.implementations.AgencyServiceImpl;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/agencies")
public class AgencyController {
    private final AgencyServiceImpl agencyServiceImpl;

    public AgencyController(AgencyServiceImpl agencyServiceImpl) {
        this.agencyServiceImpl = agencyServiceImpl;
    }

    @GetMapping
    public List<Agency> getAll(){
        return agencyServiceImpl.getAll();
    }

    @PostMapping
    public Agency create(Agency agency) {
        return agencyServiceImpl.create(agency);
    }

    @GetMapping("/{id}")
    public Optional<Agency> getAgency(@PathVariable Long id){
        return agencyServiceImpl.findById(id);
    }

}
