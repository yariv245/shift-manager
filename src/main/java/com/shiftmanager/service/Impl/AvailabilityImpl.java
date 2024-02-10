package com.shiftmanager.service.Impl;

import com.shiftmanager.dto.request.CreateAvailability;
import com.shiftmanager.dto.response.AvailabilityResponse;
import com.shiftmanager.entity.Account;
import com.shiftmanager.entity.Availability;
import com.shiftmanager.entity.TimeSlot;
import com.shiftmanager.exception.ResourceNotFoundException;
import com.shiftmanager.repository.AccountRepository;
import com.shiftmanager.repository.AvailabilityRepository;
import com.shiftmanager.repository.TimeSlotRepository;
import com.shiftmanager.service.AvailabilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AvailabilityImpl implements AvailabilityService {
    private final AvailabilityRepository availabilityRepository;
    private final AccountRepository accountRepository;
    private final TimeSlotRepository timeSlotRepository;

    @Override
    public AvailabilityResponse create(CreateAvailability request) {
        Account account = getAccountById(request.getAccountId());
        TimeSlot timeSlot = getTimeSlotById(request.getTimeSlotId());
        Availability availability = Availability.builder()
                .availableDay(request.getAvailableDay())
                .account(account)
                .timeSlot(timeSlot)
                .build();
        Availability saved = availabilityRepository.save(availability);

        return mapToAvailabilityResponse(saved);
    }

    private TimeSlot getTimeSlotById(Long timeSlotId) {
        return timeSlotRepository.findById(timeSlotId)
                .orElseThrow(() -> new ResourceNotFoundException("TimeSlot", "Id", timeSlotId));
    }

    private Account getAccountById(UUID accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account", "Id", accountId));
    }

    private AvailabilityResponse mapToAvailabilityResponse(Availability availability) {
        return AvailabilityResponse.builder()
                .day(availability.getAvailableDay())
                .start(availability.getTimeSlot().getStartSlot())
                .end(availability.getTimeSlot().getEndSlot())
                .build();
    }
}
