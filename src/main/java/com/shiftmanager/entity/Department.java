package com.shiftmanager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.UUID;

@Entity(name = "department")
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Department extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @Column(name = "name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "department",
            targetEntity = Account.class,
            fetch = FetchType.LAZY)
    private List<Account> accounts;

    @OneToOne(mappedBy = "department")
    private WorkScheduleConfiguration workScheduleConfiguration;

    @OneToMany(mappedBy = "department",
            targetEntity = WorkSchedule.class,
            fetch = FetchType.LAZY)
    private List<WorkSchedule> workSchedules;
}
