package com.shiftmanager.service.Impl;

import com.shiftmanager.dto.response.ShiftResponse;
import com.shiftmanager.repository.ShiftRepository;
import com.shiftmanager.service.ShiftService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ShiftServiceImpl implements ShiftService {
    private final ShiftRepository shiftRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<ShiftResponse> findAllByAccountId(UUID accountId) {
        return shiftRepository.findAllByAccount_Id(accountId)
                .stream()
                .map(shift -> modelMapper.map(shift, ShiftResponse.class))
                .collect(Collectors.toList());
    }
}
