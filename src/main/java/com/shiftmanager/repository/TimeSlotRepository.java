package com.shiftmanager.repository;

import com.shiftmanager.entity.TimeSlot;
import com.shiftmanager.entity.WorkSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TimeSlotRepository extends JpaRepository<TimeSlot, Long> {
}
