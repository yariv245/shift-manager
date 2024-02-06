package com.shiftmanager.repository;

import com.shiftmanager.entity.Account;
import com.shiftmanager.entity.WorkSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface WorkScheduleRepository extends JpaRepository<WorkSchedule, Long> {
}
