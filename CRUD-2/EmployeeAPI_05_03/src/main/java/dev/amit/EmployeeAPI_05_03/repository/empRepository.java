package dev.amit.EmployeeAPI_05_03.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.amit.EmployeeAPI_05_03.entity.Employee;

public interface empRepository extends JpaRepository<Employee, Long> {

}
