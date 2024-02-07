package com.shiftmanager.controller;

import com.shiftmanager.dto.request.AccountRequest;
import com.shiftmanager.dto.response.AccountResponse;
import com.shiftmanager.service.AccountService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/account")
@RequiredArgsConstructor
@Validated
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<AccountResponse> createAccount(@Valid @RequestBody AccountRequest request) {
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
}
