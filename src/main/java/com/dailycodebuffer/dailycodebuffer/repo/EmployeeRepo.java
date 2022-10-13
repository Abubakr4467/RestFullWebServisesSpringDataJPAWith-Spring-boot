package com.dailycodebuffer.dailycodebuffer.repo;

import com.dailycodebuffer.dailycodebuffer.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeEntity, String> {
}
