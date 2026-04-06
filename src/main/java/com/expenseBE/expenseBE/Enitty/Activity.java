package com.expenseBE.expenseBE.Enitty;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "activity")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long category_id;

    private Double amount;

    private LocalDateTime created_at;
}
