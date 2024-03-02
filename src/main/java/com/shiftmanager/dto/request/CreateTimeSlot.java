package com.shiftmanager.dto.request;

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
public class CreateTimeSlot {
    @NotNull
    private LocalTime startSlot;
    @NotNull
    private LocalTime endSlot;
}
