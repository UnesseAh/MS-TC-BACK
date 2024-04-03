package com.tourconnect.mctcagency;

import com.tourconnect.mctcagency.domain.Agency;
import com.tourconnect.mctcagency.repository.AgencyRepository;
import com.tourconnect.mctcagency.service.implementations.AgencyServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AgencyServiceTests {

    private AgencyServiceImpl agencyService;

    @Mock
    private AgencyRepository agencyRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        agencyService = new AgencyServiceImpl(agencyRepository);
    }

    @Test
    public void testGetAllAgencies() {
        List<Agency> agencies = new ArrayList<>();
        agencies.add(Agency.builder()
                .name("Agency 1")
                .description("Description 1")
                .build());
        agencies.add(Agency.builder()
                .name("Agency 2")
                .description("Description 2")
                .build());
        Mockito.when(agencyRepository.findAll()).thenReturn(agencies);
        List<Agency> result = agencyService.getAll();
        Assertions.assertEquals(agencies, result);
        Mockito.verify(agencyRepository, Mockito.times(1)).findAll();
    }

    @Test
    public void testCreateAgency() {
        Agency agency = Agency.builder()
                .name("Test Agency")
                .description("Test Description")
                .build();

        Mockito.when(agencyRepository.save(agency)).thenReturn(agency);
        Agency createdAgency = agencyService.create(agency);
        Assertions.assertEquals(agency, createdAgency);
        Mockito.verify(agencyRepository, Mockito.times(1)).save(agency);
    }

    @Test
    public void testFindAgencyById() {
        Agency agency = Agency.builder()
                .id(1L)
                .name("Test Agency")
                .description("Test Description")
                .build();

        Mockito.when(agencyRepository.findById(1L)).thenReturn(Optional.of(agency));
        Optional<Agency> result = agencyService.findById(1L);
        Assertions.assertEquals(Optional.of(agency), result);
        Mockito.verify(agencyRepository, Mockito.times(1)).findById(1L);
    }

    @Test
    public void testDeleteAgency() {
        Agency agency = Agency.builder()
                .id(1L)
                .name("Test Agency")
                .description("Test Description")
                .build();

        Mockito.when(agencyRepository.findById(1L)).thenReturn(Optional.of(agency));
        agencyService.delete(1L);
        Mockito.verify(agencyRepository, Mockito.times(1)).findById(1L);
        Mockito.verify(agencyRepository, Mockito.times(1)).delete(agency);
    }
}