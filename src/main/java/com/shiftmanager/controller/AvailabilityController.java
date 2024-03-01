package com.shiftmanager.controller;

import com.shiftmanager.dto.request.CreateAvailability;
import com.shiftmanager.dto.request.DeactivateAvailabilities;
import com.shiftmanager.dto.request.UpdateTimeAvailability;
import com.shiftmanager.dto.response.AvailabilityResponse;
import com.shiftmanager.service.AvailabilityService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/availability")
@RequiredArgsConstructor
@Validated
public class AvailabilityController {

    private final AvailabilityService availabilityService;

    @PostMapping("/create")
    public ResponseEntity<List<AvailabilityResponse>> createAvailability(@Valid @RequestBody CreateAvailability request) {
        List<AvailabilityResponse> response = availabilityService.create(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<AvailabilityResponse>> getAllByAccountId(@Valid
                                                                        @NotNull
                                                                        @RequestParam UUID accountId) {
        List<AvailabilityResponse> response = availabilityService.getActiveByAccountId(accountId);

        return ResponseEntity
                .ok(response);
    }

    @PutMapping("/update/time")
    public ResponseEntity<AvailabilityResponse> updateTime(@Valid @RequestBody UpdateTimeAvailability request) {
        AvailabilityResponse response = availabilityService.updateTimeById(request);

        return ResponseEntity
                .ok(response);
    }

    @PutMapping("/deactivate")
    public ResponseEntity<Boolean> deactivate(@Valid @RequestBody DeactivateAvailabilities request) {
        boolean response = availabilityService.deactivate(request);

        return ResponseEntity
                .ok(response);
    }
}
