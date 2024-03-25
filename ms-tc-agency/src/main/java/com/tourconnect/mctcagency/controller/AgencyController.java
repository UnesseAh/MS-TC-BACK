package com.tourconnect.mctcagency.controller;

import com.tourconnect.mctcagency.domain.Agency;
import com.tourconnect.mctcagency.service.interfaces.AgencyService;
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
    public Agency create(Agency agency) {
        return agencyService.create(agency);
    }

    @GetMapping("/{id}")
    public Optional<Agency> getAgency(@PathVariable Long id){
        return agencyService.findById(id);
    }

}
