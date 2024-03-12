package com.tourconnect.mctcagency.service.interfaces;

import com.tourconnect.mctcagency.domain.Agency;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AgencyService {
    List<Agency> getAll();
    Agency create(Agency agency);
    Optional<Agency> findById(Long id);
}
