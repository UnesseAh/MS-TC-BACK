package com.tourconnect.mctcagency.service.implementations;

import com.tourconnect.mctcagency.domain.Agency;
import com.tourconnect.mctcagency.repository.AgencyRepository;
import com.tourconnect.mctcagency.service.interfaces.AgencyService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AgencyServiceImpl implements AgencyService {
    private final AgencyRepository agencyRepository;

    public AgencyServiceImpl(AgencyRepository agencyRepository) {
        this.agencyRepository = agencyRepository;
    }

    public List<Agency> getAll(){
        return agencyRepository.findAll();
    }

    public Agency create(Agency agency) {
        if (agency == null){
            throw new IllegalArgumentException("Agency can't be null");
        }
        return agencyRepository.save(agency);
    }

    public Optional<Agency> findById(Long id){
        return agencyRepository.findById(id);
    }

    @Override
    public void delete(Long id) {
        Optional<Agency> agency = findById(id);
        if (agency.isEmpty()){
            throw new IllegalArgumentException("Agency with id " + id + " doesn't exist");
        }
        agencyRepository.delete(agency.get());
    }

}
