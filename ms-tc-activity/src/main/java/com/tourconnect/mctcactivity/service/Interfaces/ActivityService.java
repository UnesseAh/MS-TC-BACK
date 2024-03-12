package com.tourconnect.mctcactivity.service.Interfaces;

import com.tourconnect.mctcactivity.domain.Activity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface ActivityService {
    List<Activity> getAll();
    Activity create(Activity activity);
    Optional<Activity> findById(Long id);
}
