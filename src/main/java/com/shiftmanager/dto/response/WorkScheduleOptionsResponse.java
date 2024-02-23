package com.shiftmanager.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WorkScheduleOptionsResponse {
    private LocalDateTime startSchedule;
    private LocalDateTime endSchedule;
    private Collection<ShiftOptionResponse> shiftOptionResponses;
}
