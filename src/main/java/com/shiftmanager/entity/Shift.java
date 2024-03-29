package com.shiftmanager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity
@Table(name = "shift")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Shift extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;
    @Column(name = "start")
    private LocalDateTime start;
    @Column(name = "end")
    private LocalDateTime end;
    @Column(name = "publish")
    private Boolean publish = false;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="work_schedule_id")
    private WorkSchedule workSchedule;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="account_id")
    private Account account;
}
