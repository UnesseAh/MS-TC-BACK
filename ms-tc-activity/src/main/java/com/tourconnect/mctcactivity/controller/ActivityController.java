package com.tourconnect.mctcactivity.controller;

import com.tourconnect.mctcactivity.domain.Activity;
import com.tourconnect.mctcactivity.service.Interfaces.ActivityService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/activities")
public class ActivityController {
    private final ActivityService activityService;

    public ActivityController(ActivityService activityService) {
        this.activityService = activityService;
    }


    @GetMapping
    public List<Activity> getAll(){
        return activityService.getAll();
    }

    @PostMapping
    public Activity create(Activity activity) {
        return activityService.create(activity);
    }

    @GetMapping("/{id}")
    public Optional<Activity> getAgency(@PathVariable Long id){
        return activityService.findById(id);
    }
}
