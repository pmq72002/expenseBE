package com.expenseBE.expenseBE.service;

import com.expenseBE.expenseBE.Enitty.Activity;
import com.expenseBE.expenseBE.repository.ActivityRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class ActivityService {

    private final ActivityRepository activityRepository;

    public ActivityService(ActivityRepository activityRepository) {
        this.activityRepository = activityRepository;
    }

    public Map<LocalDate, List<Activity>> getActivitiesGroupByDate() {
        List<Activity> list = activityRepository.findAllByOrderByCreatedAtDesc();

        Map<LocalDate, List<Activity>> result = new LinkedHashMap<>();

        for (Activity a : list) {
            LocalDate date = a.getCreatedAt().toLocalDate();

            result.computeIfAbsent(date, k -> new ArrayList<>()).add(a);
        }

        return result;
    }
}
