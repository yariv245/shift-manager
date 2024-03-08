package com.shiftmanager.component;

import com.shiftmanager.entity.*;
import com.shiftmanager.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class DataBaseInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final AccountRepository accountRepository;
    private final DepartmentRepository departmentRepository;
    private final WorkScheduleConfigurationRepository workScheduleConfigurationRepository;
    private final ShiftConfigurationRepository shiftConfigurationRepository;
    private final UUID EMPLOYEE_ACCOUNT_ID = UUID.fromString("72f93290-7921-4273-b1ab-38572368b24c");
    private final UUID MANAGER_ACCOUNT_ID = UUID.fromString("72f93290-7921-4273-b1ab-38572368b24c");

    @Override
    public void run(String... args) throws Exception {
        List<Role> roles = initializeRole();
        Department department = initializeDepartment();
        initializeAccount(roles, department);
        WorkScheduleConfiguration workScheduleConfiguration = initializeWorkScheduleConfiguration(department);
        initializeShiftConfiguration(workScheduleConfiguration);
    }

    private List<ShiftConfiguration> initializeShiftConfiguration(WorkScheduleConfiguration workScheduleConfiguration) {
        ShiftConfiguration shiftConfiguration = ShiftConfiguration.builder()
                .amountOfWorkers(2)
                .day(0)
                .workScheduleConfiguration(workScheduleConfiguration)
                .build();
        ShiftConfiguration shiftConfiguration2 = ShiftConfiguration.builder()
                .amountOfWorkers(3)
                .day(0)
                .workScheduleConfiguration(workScheduleConfiguration)
                .build();
        ShiftConfiguration shiftConfiguration3 = ShiftConfiguration.builder()
                .amountOfWorkers(1)
                .day(0)
                .workScheduleConfiguration(workScheduleConfiguration)
                .build();
        ShiftConfiguration shiftConfiguration4 = ShiftConfiguration.builder()
                .amountOfWorkers(1)
                .day(0)
                .workScheduleConfiguration(workScheduleConfiguration)
                .build();

        return shiftConfigurationRepository.saveAll(List.of(shiftConfiguration, shiftConfiguration2, shiftConfiguration3, shiftConfiguration4));
    }

    private WorkScheduleConfiguration initializeWorkScheduleConfiguration(Department department) {
        WorkScheduleConfiguration workScheduleConfiguration = WorkScheduleConfiguration.builder()
                .amountOfDays(7)
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
        Account employee = Account.builder()
                .id(EMPLOYEE_ACCOUNT_ID)
                .role(roles.get(0))
//                .shifts()
//                .availabilities()
                .address("Hagititi 19 rishone lezion")
                .firstName("Yariv")
                .lastName("employee")
                .email("yariv@hom.co")
                .dateOfBirth(LocalDate.of(1995, Month.AUGUST, 22))
                .phoneNumber("547481231")
                .phonePrefix("972")
                .department(department)
                .build();

        Account manager = Account.builder()
                .id(MANAGER_ACCOUNT_ID)
                .role(roles.get(0))
//                .shifts()
//                .availabilities()
                .address("Hatezmoret 5 rishone lezion")
                .firstName("Amit")
                .lastName("manager")
                .email("amit@yah.co")
                .dateOfBirth(LocalDate.of(1995, Month.OCTOBER, 2))
                .phoneNumber("547481234")
                .phonePrefix("972")
                .department(department)
                .build();

        accountRepository.saveAll(List.of(employee,manager));
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
