package com.shiftmanager.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShiftOptionResponse {
    private LocalDate day;
    private LocalTime start;
    private LocalTime end;
    private Integer amountOfWorkers;
}
