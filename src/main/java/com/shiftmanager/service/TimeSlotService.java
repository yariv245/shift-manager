package com.shiftmanager.service;

import com.shiftmanager.dto.response.TimeSlotResponse;

import java.util.List;

public interface TimeSlotService {
    List<TimeSlotResponse> getAll();
}
