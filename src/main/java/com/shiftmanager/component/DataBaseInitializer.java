package com.shiftmanager.component;

import com.shiftmanager.entity.Account;
import com.shiftmanager.entity.Role;
import com.shiftmanager.entity.TimeSlot;
import com.shiftmanager.repository.AccountRepository;
import com.shiftmanager.repository.RoleRepository;
import com.shiftmanager.repository.TimeSlotRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
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
    private final UUID ACCOUNT_ID = UUID.fromString("72f93290-7921-4273-b1ab-38572368b24c");

    @Override
    public void run(String... args) throws Exception {
        List<Role> roles = initializeRole();
        initializeTimeSlot();
        initializeAccount(roles);
    }

    private void initializeAccount(List<Role> roles) {
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
                .build();

        accountRepository.save(account);
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
