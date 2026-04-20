package com.expenseBE.expenseBE.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class TopDayDTO {
    private LocalDate date;
    private Double total;

    public TopDayDTO(LocalDate date, Double total) {
        this.date = date;
        this.total = total;
    }

}
