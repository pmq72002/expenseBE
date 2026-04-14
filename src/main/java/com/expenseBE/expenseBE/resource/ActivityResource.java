package com.expenseBE.expenseBE.resource;

import com.expenseBE.expenseBE.Enitty.Activity;
import com.expenseBE.expenseBE.Enitty.Category;
import com.expenseBE.expenseBE.dto.ActivityDTO;
import com.expenseBE.expenseBE.repository.ActivityRepository;
import com.expenseBE.expenseBE.repository.CategoryRepository;
import com.expenseBE.expenseBE.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class ActivityResource {
    @Autowired
    private ActivityRepository activityRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    private final ActivityService activityService;

    public ActivityResource(ActivityService activityService) {
        this.activityService = activityService;
    }
    @GetMapping("/activities")
    public List<Activity> getAll() {
        return activityRepository.findAll();
    }

    @GetMapping("/group-by-date")
    public Map<LocalDate, List<Activity>> getActivities() {
        return activityService.getActivitiesGroupByDate();
    }

    @PostMapping("/activity")
    public List<Activity> saveAll(@RequestBody List<ActivityDTO> requests) {

        List<Activity> activities = requests.stream().map(r -> {

            Activity a;

            if (r.getId() != null) {
                a = activityRepository.findById(r.getId())
                        .orElse(new Activity());
            } else {
                a = new Activity();
            }

            Category category = categoryRepository.findById(r.getCategoryId())
                    .orElseThrow(() -> new RuntimeException("Category not found"));

            a.setCategory(category);
            a.setAmount(r.getAmount());
            a.setDescription(r.getDescription());
            a.setCreatedAt(LocalDateTime.parse(r.getDate() + "T00:00:00"));

            return a;

        }).toList();

        return activityRepository.saveAll(activities);
    }

    @DeleteMapping("/activity/{id}")
    public void delete(@PathVariable Long id) {
        activityRepository.deleteById(id);
    }
}
