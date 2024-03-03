package com.shiftmanager.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CreateShiftConfiguration {
    @Min(1)
    private Integer amountOfWorkers;
    @Min(1)
    private Integer shiftDay;
    @NotNull
    private LocalTime startTime;
    @NotNull
    private LocalTime endTime;
}
