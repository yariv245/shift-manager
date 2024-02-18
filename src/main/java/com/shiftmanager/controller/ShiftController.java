package com.shiftmanager.controller;

import com.shiftmanager.dto.response.ShiftResponse;
import com.shiftmanager.service.ShiftService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/shift")
@RequiredArgsConstructor
@Validated
public class ShiftController {

    private final ShiftService shiftService;

    @GetMapping("/all")
    public ResponseEntity<List<ShiftResponse>> getAllByAccountId(@Valid
                                                                        @NotNull
                                                                        @RequestParam UUID accountId) {
        List<ShiftResponse> response = shiftService.findAllByAccountId(accountId);

        return ResponseEntity
                .ok(response);
    }
}
