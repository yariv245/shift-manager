package com.shiftmanager.controller;

import com.shiftmanager.dto.response.WorkScheduleOptionsResponse;
import com.shiftmanager.service.AvailabilityOptionService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/availability/option")
@RequiredArgsConstructor
@Validated
public class AvailabilityOptionController {

    private final AvailabilityOptionService availabilityOptionService;

    @GetMapping("/all")
    public ResponseEntity<WorkScheduleOptionsResponse> getOptionsByAccountId(@Valid
                                                                        @NotNull
                                                                        @RequestParam UUID accountId) {
        WorkScheduleOptionsResponse response = availabilityOptionService.getOptionsByAccountId(accountId);

        return ResponseEntity
                .ok(response);
    }
}
