package com.expenseBE.expenseBE.repository;

import com.expenseBE.expenseBE.Enitty.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Activity> findAllByOrderByCreatedAtDesc();
}
