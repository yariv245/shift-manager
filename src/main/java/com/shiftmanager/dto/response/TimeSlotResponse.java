package com.shiftmanager.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TimeSlotResponse {
    private Long id;
    private LocalTime startSlot;
    private LocalTime endSlot;
}
