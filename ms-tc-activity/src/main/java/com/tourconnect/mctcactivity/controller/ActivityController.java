package com.tourconnect.mctcactivity.controller;

import com.tourconnect.mctcactivity.agencies.AgencyRestClient;
import com.tourconnect.mctcactivity.domain.Activity;
import com.tourconnect.mctcactivity.dto.ActivityRequestDTO;
import com.tourconnect.mctcactivity.dto.ActivityResponseDTO;
import com.tourconnect.mctcactivity.handler.exception.ResourceNotFoundException;
import com.tourconnect.mctcactivity.handler.response.GenericResponse;
import com.tourconnect.mctcactivity.model.Agency;
import com.tourconnect.mctcactivity.service.Interfaces.ActivityService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/activities")
public class ActivityController {
    private final ActivityService activityService;
    private final AgencyRestClient agencyRestClient;
    public ActivityController(ActivityService activityService, AgencyRestClient agencyRestClient) {
        this.activityService = activityService;
        this.agencyRestClient = agencyRestClient;
    }

    @GetMapping
    public ResponseEntity<?> getAll(){
        List<Activity> activities = activityService.getAll();
//        activities.forEach(activity -> {
//            activity.setAgency(agencyRestClient.findAgency(activity.getAgencyId()));
//        });

        List<ActivityResponseDTO> activityResponseDTOS = new ArrayList<>();
        activities.forEach(activity -> {
            activityResponseDTOS.add(ActivityResponseDTO.toDTO(activity));
        });
        return GenericResponse.ok(activityResponseDTOS, "Activities returned successfully");
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody @Valid ActivityRequestDTO activityRequestDTO) {
        Activity activity = activityService.create(activityRequestDTO.toEntity());
        return GenericResponse.created(
                ActivityResponseDTO.toDTO(activity),
                "Activity created successfully!"
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getActivity(@PathVariable Long id) {
        Optional<Activity> activity = activityService.findById(id);

        if(activity.isEmpty()){
            throw new ResourceNotFoundException("Activity with id " + id + " doesn't exist");
        }

//        if (activity.isPresent()){
//            Agency agency = agencyRestClient.findAgency(activity.get().getAgencyId());
//            activity.get().setAgency(agency);
//        }
        ActivityResponseDTO activityResponseDTO = ActivityResponseDTO.toDTO(activity.get());
        return GenericResponse.ok(activityResponseDTO, "Activity found") ;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        activityService.delete(id);
        return GenericResponse.deleted("Activity deleted successfully");
    }
}
