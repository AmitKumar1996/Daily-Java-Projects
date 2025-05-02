package dev.amit.EmployeeAPI_05_02.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.amit.EmployeeAPI_05_02.entity.Employee;

public interface empRepository extends JpaRepository<Employee, Long> {

}
