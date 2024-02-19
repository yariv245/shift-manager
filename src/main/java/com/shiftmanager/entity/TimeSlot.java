package com.shiftmanager.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Entity(name = "time_slot")
@Getter
@Setter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TimeSlot extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id")
    private Long id;
    @Column(name = "start_slot")
    private LocalTime startSlot;
    @Column(name = "end_slot")
    private LocalTime endSlot;

    @OneToMany(mappedBy = "timeSlot",
            targetEntity = Availability.class,
            fetch = FetchType.LAZY)
    private List<Availability> availabilities;

    @OneToMany(mappedBy = "timeSlot",
            targetEntity = ShiftConfiguration.class,
            fetch = FetchType.LAZY)
    private List<ShiftConfiguration> shiftConfigurations;
}
