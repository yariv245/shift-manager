package com.shiftmanager.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExceptionResponse {
    private String apiPath;
    private HttpStatus errorCode;
    private String errorMessage;
    @Builder.Default
    private LocalDateTime errorTime = LocalDateTime.now();
}
