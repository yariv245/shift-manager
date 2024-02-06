package com.shiftmanager.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.util.List;

@Entity(name = "time_slot")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TimeSlot extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "native")
    @Column(name = "id")
    private Long id;
    @Column(name = "start_slot")
    private LocalDateTime startSlot;
    @Column(name = "end_slot")
    private LocalDateTime endSlot;

    @OneToMany(mappedBy = "timeSlot",
            targetEntity = Availability.class)
    private List<Availability> availabilities;
}
