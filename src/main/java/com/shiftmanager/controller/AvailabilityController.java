package com.shiftmanager.controller;

import com.shiftmanager.dto.request.CreateAvailability;
import com.shiftmanager.dto.response.AccountResponse;
import com.shiftmanager.dto.response.AvailabilityResponse;
import com.shiftmanager.service.AvailabilityService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
    public ResponseEntity<AvailabilityResponse> createAccount(@Valid @RequestBody CreateAvailability request) {
        AvailabilityResponse response = availabilityService.create(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping("/all")
    public ResponseEntity<List<AvailabilityResponse>> getAllByAccountId(@Valid
                                                                        @NotNull
                                                                        @RequestParam UUID accountId) {
        List<AvailabilityResponse> response = availabilityService.getAllByAccountId(accountId);

        return ResponseEntity
                .ok(response);
    }
//
//    @PutMapping("/update")
//    public ResponseEntity<AccountResponse> update(@Valid @RequestBody UpdateAccountRequest request) {
//        AccountResponse response = accountService.update(request);
//
//        return ResponseEntity
//                .ok(response);
//    }
}
