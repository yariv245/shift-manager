package com.shiftmanager.repository;

import com.shiftmanager.entity.Availability;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface AvailabilityRepository extends JpaRepository<Availability, Long> {
    List<Availability> findAllByAccount_Id(UUID accountId);

//    Optional<Availability> findByAccount_IdAndAvailableDayAndTimeSlot_Id
//            (UUID accountId, LocalDate day, Long timeSlotId);
}
