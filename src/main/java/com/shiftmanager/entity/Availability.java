package com.shiftmanager.entity;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Table(name = "availability")
@Getter
@Builder
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Availability extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    @Builder.Default
    @Column(name = "active")
    private boolean active = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "shift_configuration_id")
    private ShiftConfiguration shiftConfiguration;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "work_schedule_id")
    private WorkSchedule workSchedule;
}
