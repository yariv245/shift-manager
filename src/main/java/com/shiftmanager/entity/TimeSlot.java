package com.shiftmanager.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;

@Entity(name = "time_slot")
@Getter @Setter @ToString
@AllArgsConstructor
@NoArgsConstructor
public class TimeSlot extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "native")
    @Column(name = "id")
    private Long id;
    @Column(name = "start")
    private LocalDateTime start;
    @Column(name = "end")
    private LocalDateTime end;
}
