package com.shiftmanager.repository;

import com.shiftmanager.entity.WorkScheduleConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface WorkScheduleConfigurationRepository extends JpaRepository<WorkScheduleConfiguration, Long> {

    Optional<WorkScheduleConfiguration> findByDepartment_Id(UUID departmentId);
}
