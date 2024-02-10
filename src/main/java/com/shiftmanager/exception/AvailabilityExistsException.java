package com.shiftmanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class AvailabilityExistsException extends RuntimeException {
    public AvailabilityExistsException(String message) {
        super(message);
    }
}
