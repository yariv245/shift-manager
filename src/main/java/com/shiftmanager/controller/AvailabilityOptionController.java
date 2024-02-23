package com.shiftmanager.controller;

import com.shiftmanager.dto.response.AvailabilityResponse;
import com.shiftmanager.service.AvailabilityService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/availability/option")
@RequiredArgsConstructor
@Validated
public class AvailabilityOptionController {

    private final AvailabilityService availabilityService;

    @GetMapping("/all")
    public ResponseEntity<List<AvailabilityResponse>> getAllByAccountId(@Valid
                                                                        @NotNull
                                                                        @RequestParam UUID accountId) {
        List<AvailabilityResponse> response = availabilityService.getActiveByAccountId(accountId);

        return ResponseEntity
                .ok(response);
    }
}
