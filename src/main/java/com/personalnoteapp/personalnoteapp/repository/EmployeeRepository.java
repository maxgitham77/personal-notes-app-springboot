package com.personalnoteapp.personalnoteapp.repository;

import com.personalnoteapp.personalnoteapp.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
