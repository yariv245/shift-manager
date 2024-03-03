package com.shiftmanager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

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
    @Column(name = "day")
    private LocalDate day;
    @Builder.Default
    @Column(name = "active")
    private boolean active = true;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "account_id")
    private Account account;
}
