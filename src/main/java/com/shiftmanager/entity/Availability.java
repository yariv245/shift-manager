package com.shiftmanager.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Entity(name = "availability")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Availability extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "native")
    @Column(name = "id")
    private Long id;
    @Column(name = "account_id", nullable = false)
    private UUID accountId;
    @Column(name = "day")
    private LocalDate day;
    @Column(name = "time_slot")
    private LocalDateTime timeSlot;
}
