package com.tourconnect.mctcactivity.service.Implementations;

import com.tourconnect.mctcactivity.domain.Activity;
import com.tourconnect.mctcactivity.repository.ActivityRepository;
import com.tourconnect.mctcactivity.service.Interfaces.ActivityService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ActivityServiceImpl implements ActivityService {
    private final ActivityRepository activityRepository;

    public ActivityServiceImpl(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    @Override
    public List<Activity> getAll() {
        return activityRepository.findAll();
    }

    @Override
    public Activity create(Activity activity) {
        return activityRepository.save(activity);
    }

    @Override
    public Optional<Activity> findById(Long id) {
        return activityRepository.findById(id);
    }
}
