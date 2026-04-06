package com.expenseBE.expenseBE.repository;

import com.expenseBE.expenseBE.Enitty.Activity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
}
