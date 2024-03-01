package com.shiftmanager.service;

import com.shiftmanager.dto.request.CreateAvailability;
import com.shiftmanager.dto.request.DeactivateAvailabilities;
import com.shiftmanager.dto.request.UpdateTimeAvailability;
import com.shiftmanager.dto.response.AvailabilityResponse;

import java.util.List;
import java.util.UUID;

public interface AvailabilityService {

    List<AvailabilityResponse> create(CreateAvailability request);

    List<AvailabilityResponse> getActiveByAccountId(UUID accountId);

    AvailabilityResponse updateTimeById(UpdateTimeAvailability request);

    boolean deactivate(DeactivateAvailabilities request);
}
