package com.shiftmanager.service;

import com.shiftmanager.dto.response.ShiftResponse;

import java.util.List;
import java.util.UUID;

public interface ShiftService {
    List<ShiftResponse> findAllByAccountId(UUID accountId);
}
