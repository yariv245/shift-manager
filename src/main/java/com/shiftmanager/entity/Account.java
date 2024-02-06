package com.shiftmanager.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.time.LocalDate;
import java.util.UUID;

@Entity(name = "account")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Account extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name = "native")
    @Column(name = "id")
    private UUID id;
    @Column(name = "role_id")
    private String roleId;
    @Column(name = "address")
    private String Address;
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
