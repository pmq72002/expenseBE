package com.expenseBE.expenseBE.dto;

import com.expenseBE.expenseBE.enums.ActivityType;
import lombok.Data;

@Data
public class ActivityDTO {
    private Long id;
    private Long categoryId;
    private Double amount;
    private String date;
    private String description;
    private ActivityType type;
}
