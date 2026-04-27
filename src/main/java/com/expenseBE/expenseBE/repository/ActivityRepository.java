package com.expenseBE.expenseBE.repository;

import com.expenseBE.expenseBE.Enitty.Activity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActivityRepository extends JpaRepository<Activity, Long> {
    List<Activity> findAllByOrderByCreatedAtDesc();

    //ngày chi nhiều nhất
    @Query("""
SELECT FUNCTION('DATE', a.createdAt),
       SUM(
         CASE 
           WHEN a.type = 'EXPENSE' THEN a.amount
           ELSE (-1 * a.amount)
         END
       )
FROM Activity a
GROUP BY FUNCTION('DATE', a.createdAt)
ORDER BY SUM(
         CASE 
           WHEN a.type = 'EXPENSE' THEN a.amount
           ELSE (-1 * a.amount)
         END
       ) DESC
""")
    List<Object[]> getTopSpendingDay();
}
