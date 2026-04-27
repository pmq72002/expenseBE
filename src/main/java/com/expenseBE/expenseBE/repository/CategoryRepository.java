package com.expenseBE.expenseBE.repository;


import com.expenseBE.expenseBE.Enitty.Category;
import com.expenseBE.expenseBE.dto.TopCategoryDTO;
import com.expenseBE.expenseBE.dto.TopDayDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    //Category chi nhiều nhất
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
GROUP BY a.category.name
ORDER BY 2 DESC
""")
    List<TopCategoryDTO> getTopCategory();
}
