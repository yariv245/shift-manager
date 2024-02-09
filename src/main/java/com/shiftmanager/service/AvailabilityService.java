package com.shiftmanager.service;

import com.shiftmanager.dto.request.CreateAvailability;
import com.shiftmanager.dto.response.AvailabilityResponse;

public interface AvailabilityService {

    AvailabilityResponse create(CreateAvailability request);
}
