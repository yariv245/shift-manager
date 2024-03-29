package com.shiftmanager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "work_schedule_configuration")
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class WorkScheduleConfiguration extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @Column(name = "amount_of_days")
    private Integer amountOfDays;
    @Column(name = "day_in_week")
    private Integer dayInWeek;
    @Column(name = "start_time")
    private LocalTime startTime;

    @OneToMany(mappedBy = "workScheduleConfiguration",
            targetEntity = ShiftConfiguration.class)
    private List<ShiftConfiguration> shiftConfigurations;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id", referencedColumnName = "id")
    private Department department;
}
