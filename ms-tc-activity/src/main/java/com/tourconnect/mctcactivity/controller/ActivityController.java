package com.tourconnect.mctcactivity.controller;

import com.tourconnect.mctcactivity.agencies.AgencyRestClient;
import com.tourconnect.mctcactivity.domain.Activity;
import com.tourconnect.mctcactivity.model.Agency;
import com.tourconnect.mctcactivity.service.Interfaces.ActivityService;
import org.springframework.web.bind.annotation.*;

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
    public List<Activity> getAll(){
        List<Activity> activities = activityService.getAll();
        activities.forEach(activity -> {
            activity.setAgency(agencyRestClient.findAgency(activity.getAgencyId()));
        });
        return activities;
    }

    @PostMapping
    public Activity create(Activity activity) {
        return activityService.create(activity);
    }

    @GetMapping("/{id}")
    public Optional<Activity> getActivity(@PathVariable Long id){
        Optional<Activity> activity = activityService.findById(id);

        if (activity.isPresent()){
            Agency agency = agencyRestClient.findAgency(activity.get().getAgencyId());
            activity.get().setAgency(agency);
        }

        return activity;
    }
}
