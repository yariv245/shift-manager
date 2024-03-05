package com.shiftmanager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "work_schedule")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class WorkSchedule extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @Column(name = "start_schedule")
    private LocalDateTime startSchedule;
    @Column(name = "end_schedule")
    private LocalDateTime endSchedule;
    @Column(name = "amount_of_workers")
    private Long amountOfWorkers;
    @Column(name = "work_schedule_number")
    private Long workScheduleNumber;
    @Column(name = "publish")
    private Boolean publish = false;

    @OneToMany(mappedBy = "workSchedule",
            targetEntity = Shift.class)
    private List<Shift> shifts;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany(mappedBy = "workSchedule",
            targetEntity = Availability.class,
            fetch = FetchType.LAZY)
    private List<Availability> availabilities;
}
