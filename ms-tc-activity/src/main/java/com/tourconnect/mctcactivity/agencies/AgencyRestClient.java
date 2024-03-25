package com.tourconnect.mctcactivity.agencies;

import com.tourconnect.mctcactivity.model.Agency;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "MS-TC-AGENCY")
public interface AgencyRestClient {
    @GetMapping("/agencies/{id}")
    @CircuitBreaker(name = "agencyService" , fallbackMethod = "defaultFindAgency")
    Agency findAgency(@PathVariable Long id);
    @CircuitBreaker(name = "agencyService" , fallbackMethod = "defaultFindAllAgencies")
    @GetMapping("/agencies")
    List<Agency> findAllAgencies();

    default Agency defaultFindAgency(Long id, Exception exception){
        Agency agency = new Agency();
        agency.setId(id);
        agency.setName("not available");
        agency.setCity("not available");
        agency.setEmail("not available");
        agency.setAddress("not available");
        agency.setDescription("not available");
        agency.setPhoneNumber("not available");
        return agency;
    }

    default List<Agency> defaultFindAllAgencies(Exception exception){
        return List.of();
    }
}
