package com.shiftmanager.entity;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.relational.core.sql.In;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity(name = "shift_configuration")
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ShiftConfiguration extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    @Column(name = "amount_of_workers")
    private Integer amountOfWorkers;
    @Column(name = "shift_day")
    private Integer shiftDay;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "work_schedule_configuration_id")
    private WorkScheduleConfiguration workScheduleConfiguration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "time_slot_id")
    private TimeSlot timeSlot;
}
