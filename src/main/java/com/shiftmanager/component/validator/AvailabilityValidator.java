package com.shiftmanager.component.validator;

import com.shiftmanager.entity.Availability;

import java.util.List;

public interface AvailabilityValidator {
    void validate(Availability availability);

    void validate(List<Availability> availabilities);
}
