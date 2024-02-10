package com.shiftmanager.component.validator.Impl;

import com.shiftmanager.component.validator.AvailabilityValidator;
import com.shiftmanager.entity.Availability;
import com.shiftmanager.entity.TimeSlot;
import com.shiftmanager.exception.AvailabilityExistsException;
import com.shiftmanager.repository.AvailabilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AvailabilityValidatorImpl implements AvailabilityValidator {
    private final AvailabilityRepository availabilityRepository;

    @Override
    public void validate(Availability availability) {
        Optional<Availability> availabilityOptional = availabilityRepository.findByAccount_IdAndAvailableDayAndTimeSlot_Id(
                availability.getAccount().getId(), availability.getAvailableDay(), availability.getTimeSlot().getId());

        if (availabilityOptional.isPresent())
            throwAvailabilityExists(availability);
    }

    private void throwAvailabilityExists(Availability availability) {
        LocalDate availableDay = availability.getAvailableDay();
        TimeSlot timeSlot = availability.getTimeSlot();
        String format = String.format("Availability Exists day: %s , start: %s , end: %S", availableDay,
                timeSlot.getStartSlot(), timeSlot.getEndSlot());

        throw new AvailabilityExistsException(format);
    }
}
