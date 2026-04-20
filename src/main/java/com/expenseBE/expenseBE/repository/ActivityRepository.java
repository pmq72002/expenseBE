package com.expenseBE.expenseBE.repository;

import com.expenseBE.expenseBE.Enitty.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Activity> findAllByOrderByCreatedAtDesc();

    //ngày chi nhiều nhất
    @Query("""
    SELECT FUNCTION('DATE', a.createdAt), SUM(a.amount)
    FROM Activity a
    GROUP BY FUNCTION('DATE', a.createdAt)
    ORDER BY SUM(a.amount) DESC
""")
    List<Object[]> getTopSpendingDay();
}
