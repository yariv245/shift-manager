package com.shiftmanager.dto.request;

import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateAvailability {
    @FutureOrPresent
    private LocalDate availableDay;
    @org.hibernate.validator.constraints.UUID
    private UUID accountId;
    // todo: fix the start and end time
}
