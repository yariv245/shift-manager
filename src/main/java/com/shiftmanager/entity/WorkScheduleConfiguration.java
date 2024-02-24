package com.shiftmanager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity(name = "work_schedule_configuration")
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class WorkScheduleConfiguration extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    @Column(name = "start_schedule")
    private LocalDateTime startSchedule;
    @Column(name = "end_schedule")
    private LocalDateTime endSchedule;

    @OneToMany(mappedBy = "workScheduleConfiguration",
            targetEntity = ShiftConfiguration.class)
    private List<ShiftConfiguration> shiftConfigurations;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;
}
