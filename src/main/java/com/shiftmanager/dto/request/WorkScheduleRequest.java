package com.shiftmanager.dto.request;

import com.shiftmanager.entity.Shift;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkScheduleRequest {
    private LocalDateTime startSchedule;
    private LocalDateTime endSchedule;
    private Long amountOfWorkers;

    private List<Shift> shifts;
}
