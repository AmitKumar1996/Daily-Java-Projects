package dev.amit.EmployeeAPI_04_29.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.amit.EmployeeAPI_04_29.entity.Employee;

public interface employeeRepository  extends JpaRepository<Employee, Long>{

}
