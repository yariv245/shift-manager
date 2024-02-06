package com.shiftmanager.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

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
    @Column(name = "start")
    private LocalDateTime start;
    @Column(name = "end")
    private LocalDateTime end;
    @Column(name = "amount_of_workers")
    private Long amountOfWorkers;
}
