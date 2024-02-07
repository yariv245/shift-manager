package com.shiftmanager.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponse {
    private String Address;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dateOfBirth;
    private String phoneNumber;
    private String phonePrefix;
}
