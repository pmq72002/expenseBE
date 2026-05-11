package com.expenseBE.expenseBE.repository;


import com.expenseBE.expenseBE.Enitty.Category;
import com.expenseBE.expenseBE.dto.TopCategoryDTO;
import com.expenseBE.expenseBE.dto.TopDayDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("""
    SELECT new com.expenseBE.expenseBE.dto.TopCategoryDTO(
        a.category.name,
        CAST(SUM(
            CASE
                WHEN a.type = 'EXPENSE' THEN a.amount
                ELSE -a.amount
            END
        ) as double)
    )
    FROM Activity a
    WHERE a.createdAt >= :start
      AND a.createdAt < :end
    GROUP BY a.category.name
    ORDER BY 2 DESC
    """)
    List<TopCategoryDTO> getTopCategory(
            @Param("start") LocalDateTime start,
            @Param("end") LocalDateTime end
    );
}
