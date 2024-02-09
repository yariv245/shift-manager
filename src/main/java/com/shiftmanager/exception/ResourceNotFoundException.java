package com.shiftmanager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.UUID;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {
    public ResourceNotFoundException(String resourceName, String filedName, String fieldValue) {
        super(String.format("%s not found with the given input data %s: %s", resourceName, filedName, fieldValue));
    }

    public ResourceNotFoundException(String resourceName, String filedName, Long fieldValue) {
        super(String.format("%s not found with the given input data %s: %s", resourceName, filedName, fieldValue));
    }

    public ResourceNotFoundException(String resourceName, String filedName, UUID fieldValue) {
        super(String.format("%s not found with the given input data %s: %s", resourceName, filedName, fieldValue));
    }
}
