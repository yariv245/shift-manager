package com.shiftmanager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "shift_configuration")
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ShiftConfiguration extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @Column(name = "amount_of_workers")
    private Integer amountOfWorkers;
    @Column(name = "shift_day")
    private Integer day;
    @Column(name = "start_time")
    private LocalTime startTime;
    @Column(name = "length")
    private LocalTime length;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "work_schedule_configuration_id")
    private WorkScheduleConfiguration workScheduleConfiguration;

    @OneToMany(mappedBy = "shiftConfiguration",
            targetEntity = Availability.class,
            fetch = FetchType.LAZY)
    private List<Availability> availabilities;
}
