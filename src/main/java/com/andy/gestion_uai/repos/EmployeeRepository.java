package com.andy.gestion_uai.repos;

import com.andy.gestion_uai.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}