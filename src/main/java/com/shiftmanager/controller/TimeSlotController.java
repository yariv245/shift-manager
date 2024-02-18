package com.shiftmanager.controller;

import com.shiftmanager.dto.response.TimeSlotResponse;
import com.shiftmanager.service.TimeSlotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/time-slot")
@RequiredArgsConstructor
@Validated
public class TimeSlotController {

    private final TimeSlotService timeSlotService;

    @GetMapping("/all")
    public ResponseEntity<List<TimeSlotResponse>> getAll() {
        List<TimeSlotResponse> response = timeSlotService.getAll();

        return ResponseEntity
                .ok(response);
    }
}
