package com.shiftmanager.controller;

import com.shiftmanager.dto.request.CreateAccountRequest;
import com.shiftmanager.dto.request.UpdateAccountRequest;
import com.shiftmanager.dto.response.AccountResponse;
import com.shiftmanager.service.AccountService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
@Validated
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<AccountResponse> createAccount(@Valid @RequestBody CreateAccountRequest request) {
        AccountResponse response = accountService.create(request);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(response);
    }

    @GetMapping
    public ResponseEntity<AccountResponse> getByPhoneNumber(@RequestParam
                                                            @Pattern(regexp = "(^$|[0-9]{9})", message = "Mobile number must be 9 digits")
                                                                    String mobileNumber,
                                                            @NotBlank String mobileNumberPrefix) {
        AccountResponse response = accountService.getByPhoneNumber(mobileNumber, mobileNumberPrefix);

        return ResponseEntity
                .ok(response);
    }

    @PutMapping("/update")
    public ResponseEntity<AccountResponse> update(@Valid @RequestBody UpdateAccountRequest request) {
        AccountResponse response = accountService.update(request);

        return ResponseEntity
                .ok(response);
    }
}
