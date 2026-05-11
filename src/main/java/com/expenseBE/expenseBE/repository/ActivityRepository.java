package com.expenseBE.expenseBE.repository;

import com.expenseBE.expenseBE.Enitty.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

    List<Activity> findAllByOrderByCreatedAtDesc();

    @Query("""
    SELECT FUNCTION('DATE', a.createdAt),
           SUM(
             CASE
               WHEN a.type = 'EXPENSE' THEN a.amount
               ELSE (-1 * a.amount)
             END
           )
    FROM Activity a
    WHERE a.createdAt >= :start
      AND a.createdAt < :end
    GROUP BY FUNCTION('DATE', a.createdAt)
    ORDER BY SUM(
             CASE
               WHEN a.type = 'EXPENSE' THEN a.amount
               ELSE (-1 * a.amount)
             END
           ) DESC
    """)
    List<Object[]> getTopSpendingDay(
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end
    );
}
