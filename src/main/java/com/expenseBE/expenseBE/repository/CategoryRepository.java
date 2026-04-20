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
        SUM(a.amount)
    )
    FROM Activity a
    GROUP BY a.category.name
    ORDER BY SUM(a.amount) DESC
""")
    List<TopCategoryDTO> getTopCategory();
}
