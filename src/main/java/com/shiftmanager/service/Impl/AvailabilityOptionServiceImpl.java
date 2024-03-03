package com.shiftmanager.service.Impl;

import com.shiftmanager.dto.response.ShiftOptionResponse;
import com.shiftmanager.dto.response.WorkScheduleOptionsResponse;
import com.shiftmanager.entity.Account;
import com.shiftmanager.entity.ShiftConfiguration;
import com.shiftmanager.entity.WorkSchedule;
import com.shiftmanager.entity.WorkScheduleConfiguration;
import com.shiftmanager.exception.ResourceNotFoundException;
import com.shiftmanager.repository.AccountRepository;
import com.shiftmanager.repository.WorkScheduleConfigurationRepository;
import com.shiftmanager.repository.WorkScheduleRepository;
import com.shiftmanager.service.AvailabilityOptionService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class AvailabilityOptionServiceImpl implements AvailabilityOptionService {

    private final AccountRepository accountRepository;
    private final WorkScheduleConfigurationRepository workScheduleConfigurationRepository;
    private final WorkScheduleRepository workScheduleRepository;
    private final ModelMapper modelMapper;

    @Override
    public WorkScheduleOptionsResponse getOptionsByAccountId(UUID accountId) {
        Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new ResourceNotFoundException("Account", "accountId", accountId));
        UUID departmentId = account.getDepartment().getId();
        WorkSchedule workSchedule = workScheduleRepository.findByDepartment_Id(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("WorkSchedule", "departmentId", departmentId));
        WorkScheduleConfiguration workScheduleConfiguration = workScheduleConfigurationRepository.findByDepartment_Id(departmentId)
                .orElseThrow(() -> new ResourceNotFoundException("WorkScheduleConfiguration", "departmentId", departmentId));

        return mapToWorkScheduleOptions(workSchedule, workScheduleConfiguration);
    }

    private WorkScheduleOptionsResponse mapToWorkScheduleOptions(WorkSchedule workSchedule, WorkScheduleConfiguration workScheduleConfiguration) {
        WorkScheduleOptionsResponse response = modelMapper.map(workSchedule, WorkScheduleOptionsResponse.class);
        List<ShiftOptionResponse> shiftOptionResponses = workScheduleConfiguration.getShiftConfigurations()
                .stream()
                .map(shiftConfiguration -> mapToShiftOption(shiftConfiguration, response.getStartSchedule()))
                .collect(Collectors.toList());
        response.setShiftOptionResponses(shiftOptionResponses);

        return response;
    }

    private ShiftOptionResponse mapToShiftOption(ShiftConfiguration shiftConfiguration, LocalDateTime startSchedule) {
        LocalDate day = getShiftDay(shiftConfiguration, startSchedule);

        return ShiftOptionResponse.builder()
                .day(day)
                // todo: fix the start and end time
//                .start(shiftConfiguration.getTimeSlot().getStartSlot())
//                .end(shiftConfiguration.getTimeSlot().getEndSlot())
                .amountOfWorkers(shiftConfiguration.getAmountOfWorkers())
                .build();
    }

    private LocalDate getShiftDay(ShiftConfiguration shiftConfiguration, LocalDateTime startSchedule) {
        return startSchedule.plusDays(shiftConfiguration.getShiftDay()).toLocalDate();
    }
}
