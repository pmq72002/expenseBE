package com.expenseBE.expenseBE.Enitty;

import com.expenseBE.expenseBE.enums.ActivityType;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "budget")
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long category_id;
    private LocalDate month;
    private Double max_amount;

    @Enumerated(EnumType.STRING)
    private ActivityType type;
}
