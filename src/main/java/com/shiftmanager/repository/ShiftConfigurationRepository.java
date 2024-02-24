package com.shiftmanager.repository;

import com.shiftmanager.entity.ShiftConfiguration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShiftConfigurationRepository extends JpaRepository<ShiftConfiguration,Long> {
}
