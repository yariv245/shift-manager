package com.shiftmanager.dto.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UpdateAccountRequest {
    private String address;
    private String firstName;
    private String lastName;
    private String email;
    private LocalDate dateOfBirth;
    @NotBlank
    private String phoneNumber;
    @NotBlank
    private String phonePrefix;
}
