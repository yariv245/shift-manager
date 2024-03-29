package com.shiftmanager.dto.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class CreateWorkScheduleConfiguration {
    @org.hibernate.validator.constraints.UUID
    private UUID accountId;
    @Min(1)
    private Integer amountOfDays;
    @NotNull
    private List<@Valid CreateShiftConfiguration> shiftConfigurations;
}
