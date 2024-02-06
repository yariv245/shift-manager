package com.shiftmanager.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "shift")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Shift extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "native")
    @Column(name = "id")
    private Long id;
    @Column(name = "account_id", nullable = false)
    private UUID accountId;
    @Column(name = "start")
    private LocalDateTime start;
    @Column(name = "end")
    private LocalDateTime end;
    @Column(name = "work_schedule_id")
    private Long workScheduleId;
}
