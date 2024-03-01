package com.shiftmanager.service.Impl;

import com.shiftmanager.dto.request.CreateWorkScheduleConfiguration;
import com.shiftmanager.repository.WorkScheduleConfigurationRepository;
import com.shiftmanager.service.WorkScheduleConfigurationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkScheduleConfigurationServiceImpl implements WorkScheduleConfigurationService {

    private final WorkScheduleConfigurationRepository workScheduleConfigurationRepository;

    @Override
    public void create(CreateWorkScheduleConfiguration request) {

    }
}
