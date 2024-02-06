package com.shiftmanager.repository;

import com.shiftmanager.entity.Account;
import com.shiftmanager.entity.Shift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ShiftRepository extends JpaRepository<Shift, Long> {
}
