package com.shiftmanager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "shift")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Shift extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    @Column(name = "start_shift")
    private LocalDateTime startShift;
    @Column(name = "end_shift")
    private LocalDateTime endShift;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="work_schedule_id")
    private WorkSchedule workSchedule;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="account_id")
    private Account account;
}
