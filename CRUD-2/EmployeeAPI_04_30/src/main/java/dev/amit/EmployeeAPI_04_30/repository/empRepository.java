package dev.amit.EmployeeAPI_04_30.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.amit.EmployeeAPI_04_30.entity.Employee;

public interface empRepository extends JpaRepository<Employee, Long> {

}
