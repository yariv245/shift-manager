package com.shiftmanager.component.validator.Impl;

import com.shiftmanager.component.validator.AvailabilityValidator;
import com.shiftmanager.entity.Availability;
import com.shiftmanager.exception.AvailabilityExistsException;
import com.shiftmanager.repository.AvailabilityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AvailabilityValidatorImpl implements AvailabilityValidator {
    private final AvailabilityRepository availabilityRepository;

    @Override
    public void validate(Availability availability) {
        // todo: fix the start and end time
        Optional<Availability> availabilityOptional = availabilityRepository.findByAccount_IdAndAvailableDayAndTimeSlot_Id(
                availability.getAccount().getId(), availability.getDay(), 123L);

        if (availabilityOptional.isPresent()) // todo: change it to Exception and catch in the controller adviser
            throwAvailabilityExists(availability);
    }

    @Override
    public void validate(List<Availability> availabilities) {
        availabilities
                .forEach(this::validate);
    }

    private void throwAvailabilityExists(Availability availability) {
        LocalDate availableDay = availability.getDay();
//        TimeSlot timeSlot = availability.getTimeSlot();
        String format = String.format("Availability Exists day: %s , start: %s , end: %S", availableDay,
                "startTime", "endTime");

        throw new AvailabilityExistsException(format);
    }
}
