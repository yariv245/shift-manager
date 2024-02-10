package com.shiftmanager.service;

import com.shiftmanager.dto.request.CreateAvailability;
import com.shiftmanager.dto.request.UpdateTimeAvailability;
import com.shiftmanager.dto.response.AvailabilityResponse;

import java.util.List;
import java.util.UUID;

public interface AvailabilityService {

    AvailabilityResponse create(CreateAvailability request);

    List<AvailabilityResponse> getAllByAccountId(UUID accountId);

    AvailabilityResponse updateTimeById(UpdateTimeAvailability request);
}
