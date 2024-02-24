package com.shiftmanager.component;

import com.shiftmanager.entity.*;
import com.shiftmanager.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DataBaseInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final TimeSlotRepository timeSlotRepository;
    private final AccountRepository accountRepository;
    private final DepartmentRepository departmentRepository;
    private final WorkScheduleConfigurationRepository workScheduleConfigurationRepository;
    private final ShiftConfigurationRepository shiftConfigurationRepository;
    private final UUID ACCOUNT_ID = UUID.fromString("72f93290-7921-4273-b1ab-38572368b24c");

    @Override
    public void run(String... args) throws Exception {
        List<Role> roles = initializeRole();
        List<TimeSlot> timeSlots = initializeTimeSlot();
        Department department = initializeDepartment();
        initializeAccount(roles, department);
        WorkScheduleConfiguration workScheduleConfiguration = initializeWorkScheduleConfiguration(department);
        initializeShiftConfiguration(workScheduleConfiguration, timeSlots);
    }

    private List<ShiftConfiguration> initializeShiftConfiguration(WorkScheduleConfiguration workScheduleConfiguration, List<TimeSlot> timeSlots) {
        ShiftConfiguration shiftConfiguration = ShiftConfiguration.builder()
                .amountOfWorkers(2)
                .shiftDay(0)
                .workScheduleConfiguration(workScheduleConfiguration)
                .timeSlot(timeSlots.get(0))
                .build();
        ShiftConfiguration shiftConfiguration2 = ShiftConfiguration.builder()
                .amountOfWorkers(3)
                .shiftDay(0)
                .workScheduleConfiguration(workScheduleConfiguration)
                .timeSlot(timeSlots.get(1))
                .build();
        ShiftConfiguration shiftConfiguration3 = ShiftConfiguration.builder()
                .amountOfWorkers(1)
                .shiftDay(0)
                .workScheduleConfiguration(workScheduleConfiguration)
                .timeSlot(timeSlots.get(2))
                .build();
        ShiftConfiguration shiftConfiguration4 = ShiftConfiguration.builder()
                .amountOfWorkers(1)
                .shiftDay(0)
                .workScheduleConfiguration(workScheduleConfiguration)
                .timeSlot(timeSlots.get(3))
                .build();

        return shiftConfigurationRepository.saveAll(List.of(shiftConfiguration, shiftConfiguration2, shiftConfiguration3, shiftConfiguration4));
    }

    private WorkScheduleConfiguration initializeWorkScheduleConfiguration(Department department) {
        WorkScheduleConfiguration workScheduleConfiguration = WorkScheduleConfiguration.builder()
                .startSchedule(LocalDateTime.of(2024, Month.FEBRUARY, 18, 0, 0))
                .endSchedule(LocalDateTime.of(2024, Month.FEBRUARY, 25, 0, 0))
                .department(department)
                .build();

        return workScheduleConfigurationRepository.save(workScheduleConfiguration);
    }

    private Department initializeDepartment() {
        Department demi_call_center = Department.builder()
                .name("Demi call center")
                .build();
        return departmentRepository.save(demi_call_center);
    }

    private void initializeAccount(List<Role> roles, Department department) {
        Account account = Account.builder()
                .id(ACCOUNT_ID)
                .role(roles.get(0))
//                .shifts()
//                .availabilities()
                .address("Hagititi 19 rishone lezion")
                .firstName("Yariv")
                .lastName("Men")
                .email("yariv@hom.co")
                .dateOfBirth(LocalDate.of(1995, Month.AUGUST, 22))
                .phoneNumber("524594598")
                .phonePrefix("972")
                .department(department)
                .build();

        accountRepository.save(account);
    }

    private List<TimeSlot> initializeTimeSlot() {
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

        return timeSlotRepository.saveAll(List.of(first, mid, mid2, last));

    }

    private List<Role> initializeRole() {
        Role employee = Role.builder()
                .id(1L)
                .name("Employee")
                .build();
        Role manager = Role.builder()
                .id(2L)
                .name("Manager")
                .build();

        return roleRepository.saveAll(List.of(employee, manager));
    }
}
