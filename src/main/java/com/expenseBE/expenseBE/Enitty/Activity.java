package com.expenseBE.expenseBE.Enitty;

import jakarta.persistence.*;
import lombok.Data;
import com.expenseBE.expenseBE.enums.ActivityType;


import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "activity")
public class Activity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    private Double amount;

    @Enumerated(EnumType.STRING)
    private ActivityType type;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    private String description;
}
