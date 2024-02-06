package com.shiftmanager.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "work_schedule")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class WorkSchedule extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "native")
    @Column(name = "id")
    private Long id;
    @Column(name = "start_schedule")
    private LocalDateTime startSchedule;
    @Column(name = "end_schedule")
    private LocalDateTime endSchedule;
    @Column(name = "amount_of_workers")
    private Long amountOfWorkers;
    @OneToMany(mappedBy = "workSchedule",
            targetEntity = Shift.class)
    private List<Shift> shifts;
}
