package com.shiftmanager.controller;

import com.shiftmanager.dto.request.CreateWorkScheduleConfiguration;
import com.shiftmanager.service.WorkScheduleConfigurationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/work-schedule-configuration")
@RequiredArgsConstructor
@Validated
public class WorkScheduleConfigurationController {
    private final WorkScheduleConfigurationService workScheduleConfigurationService;

    @PostMapping("/create")
    public ResponseEntity<Void> create(@Valid @RequestBody CreateWorkScheduleConfiguration request){
        workScheduleConfigurationService.create(request);

        return ResponseEntity.ok().build();
    }
}
