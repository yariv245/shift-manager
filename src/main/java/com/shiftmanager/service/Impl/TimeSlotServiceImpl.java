package com.shiftmanager.service.Impl;

import com.shiftmanager.dto.response.TimeSlotResponse;
import com.shiftmanager.repository.TimeSlotRepository;
import com.shiftmanager.service.TimeSlotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class TimeSlotServiceImpl implements TimeSlotService {

    private final TimeSlotRepository timeSlotRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<TimeSlotResponse> getAll() {
        return timeSlotRepository.findAll()
                .stream()
                .map(timeSlot -> modelMapper.map(timeSlot, TimeSlotResponse.class))
                .collect(Collectors.toList());
    }
}
