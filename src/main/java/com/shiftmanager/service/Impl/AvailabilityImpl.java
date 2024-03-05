package com.shiftmanager.service.Impl;

import com.shiftmanager.component.validator.AvailabilityValidator;
import com.shiftmanager.dto.request.CreateAvailability;
import com.shiftmanager.dto.request.DeactivateAvailabilities;
import com.shiftmanager.dto.request.UpdateTimeAvailability;
import com.shiftmanager.dto.response.AvailabilityResponse;
import com.shiftmanager.entity.Account;
import com.shiftmanager.entity.Availability;
import com.shiftmanager.exception.ResourceNotFoundException;
import com.shiftmanager.repository.AccountRepository;
import com.shiftmanager.repository.AvailabilityRepository;
import com.shiftmanager.service.AvailabilityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AvailabilityImpl implements AvailabilityService {
    private final AvailabilityRepository availabilityRepository;
    private final AvailabilityValidator availabilityValidator;
    private final AccountRepository accountRepository;

    @Override
    public AvailabilityResponse create(CreateAvailability request) {
        Account account = getAccountById(request.getAccountId());
        Availability availability = Availability.builder()
//                .day(request.getAvailableDay())
                .account(account)
                .build();
        availabilityValidator.validate(availability);
        Availability saved = availabilityRepository.save(availability);

        return mapToAvailabilityResponse(saved);
    }

    @Override
    public List<AvailabilityResponse> getActiveByAccountId(UUID accountId) {
        return availabilityRepository
                .findAllByAccount_Id(accountId)
                .stream()
                .filter(Availability::isActive)
                .map(this::mapToAvailabilityResponse)
                .collect(Collectors.toList());
    }

    @Override
    public AvailabilityResponse updateTimeById(UpdateTimeAvailability request) {
        Availability availability = getAvailability(request.getAvailabilityId());
        // todo: udpate the start and end
        availabilityValidator.validate(availability);
        Availability saved = availabilityRepository.save(availability);

        return mapToAvailabilityResponse(saved);
    }

    @Override
    public boolean deactivate(DeactivateAvailabilities request) {
        List<Availability> availabilities = availabilityRepository.findAllById(request.getAvailabilityIds());
        availabilities.forEach(availability -> availability.setActive(false));
        availabilityRepository.saveAll(availabilities);

        return true;
    }

    private Availability getAvailability(Long availabilityId) {
        return availabilityRepository.findById(availabilityId)
                .orElseThrow(() -> new ResourceNotFoundException("Availability", "Id", availabilityId));
    }

    private Account getAccountById(UUID accountId) {
        return accountRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account", "Id", accountId));
    }

    private AvailabilityResponse mapToAvailabilityResponse(Availability availability) {
        return AvailabilityResponse.builder()
                .id(availability.getId())
//                .day(availability.getDay())
                // todo: set the start and end time
//                .start(availability.getTimeSlot().getStartSlot())
//                .end(availability.getTimeSlot().getEndSlot())
                .build();
    }
}
