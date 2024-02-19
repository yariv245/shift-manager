package com.shiftmanager.service.Impl;

import com.shiftmanager.repository.WorkScheduleRepository;
import com.shiftmanager.service.WorkScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkScheduleServiceImpl implements WorkScheduleService {

    private final WorkScheduleRepository workScheduleRepository;

    public void create() {


    }
}
