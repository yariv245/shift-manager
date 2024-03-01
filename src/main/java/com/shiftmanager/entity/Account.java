package com.shiftmanager.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "account")
@Getter
@Builder
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Account extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    @JoinColumn(name = "role_id")
    private Role role;

    @OneToMany(mappedBy = "account",
            targetEntity = Shift.class,
            fetch = FetchType.LAZY)
    private List<Shift> shifts;

    @OneToMany(mappedBy = "account",
            targetEntity = Availability.class,
            fetch = FetchType.LAZY)
    private List<Availability> availabilities;

    @ManyToOne(fetch = FetchType.LAZY,
            cascade = CascadeType.PERSIST)
    @JoinColumn(name = "department_id")
    private Department department;

    @Column(name = "address")
    private String address;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email")
    private String email;
    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;
    @Column(name = "phone_number", nullable = false)
    private String phoneNumber;
    @Column(name = "phone_prefix", nullable = false)
    private String phonePrefix;
}
