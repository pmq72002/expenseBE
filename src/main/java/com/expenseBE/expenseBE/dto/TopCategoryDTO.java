package com.expenseBE.expenseBE.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TopCategoryDTO {
    private String name;
    private Double total;

    public TopCategoryDTO(String name, Double total) {
        this.name = name;
        this.total = total;
    }
}
