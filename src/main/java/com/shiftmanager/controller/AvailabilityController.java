package com.shiftmanager.controller;

import com.shiftmanager.dto.request.CreateAvailability;
import com.shiftmanager.dto.response.AvailabilityResponse;
import com.shiftmanager.service.AvailabilityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

//    @GetMapping
//    public ResponseEntity<AccountResponse> getByPhoneNumber(@RequestParam
//                                                            @Pattern(regexp = "(^$|[0-9]{9})", message = "Mobile number must be 9 digits")
//                                                                    String mobileNumber,
//                                                            @NotBlank String mobileNumberPrefix) {
//        AccountResponse response = accountService.getByPhoneNumber(mobileNumber, mobileNumberPrefix);
//
//        return ResponseEntity
//                .ok(response);
//    }
//
//    @PutMapping("/update")
//    public ResponseEntity<AccountResponse> update(@Valid @RequestBody UpdateAccountRequest request) {
//        AccountResponse response = accountService.update(request);
//
//        return ResponseEntity
//                .ok(response);
//    }
}
