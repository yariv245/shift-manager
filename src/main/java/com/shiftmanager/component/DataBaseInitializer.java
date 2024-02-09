package com.shiftmanager.component;

import com.shiftmanager.entity.Role;
import com.shiftmanager.entity.TimeSlot;
import com.shiftmanager.repository.RoleRepository;
import com.shiftmanager.repository.TimeSlotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DataBaseInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final TimeSlotRepository timeSlotRepository;

    @Override
    public void run(String... args) throws Exception {
        initializeRole();
        initializeTimeSlot();
    }

    private void initializeTimeSlot() {
        TimeSlot first = TimeSlot.builder()
                .startSlot(LocalTime.of(6, 0))
                .endSlot(LocalTime.of(15, 0))
                .build();

        TimeSlot mid = TimeSlot.builder()
                .startSlot(LocalTime.of(7, 0))
                .endSlot(LocalTime.of(16, 0))
                .build();

        TimeSlot mid2 = TimeSlot.builder()
                .startSlot(LocalTime.of(8, 0))
                .endSlot(LocalTime.of(17, 0))
                .build();

        TimeSlot last = TimeSlot.builder()
                .startSlot(LocalTime.of(10, 0))
                .endSlot(LocalTime.of(19, 0))
                .build();

        timeSlotRepository.saveAll(List.of(first, mid, mid2, last));

    }

    private void initializeRole() {
        Role employee = Role.builder()
                .id(1L)
                .name("Employee")
                .build();
        Role manager = Role.builder()
                .id(2L)
                .name("Manager")
                .build();

        roleRepository.saveAll(List.of(employee, manager));
    }
}
