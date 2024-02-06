package com.shiftmanager.repository;

import com.shiftmanager.entity.Role;
import com.shiftmanager.entity.WorkSchedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
}
