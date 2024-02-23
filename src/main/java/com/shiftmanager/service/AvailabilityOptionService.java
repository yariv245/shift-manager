package com.shiftmanager.service;


import com.shiftmanager.dto.response.WorkScheduleOptionsResponse;

import java.util.UUID;

public interface AvailabilityOptionService {

    WorkScheduleOptionsResponse getOptionsByAccountId(UUID accountId);
}
