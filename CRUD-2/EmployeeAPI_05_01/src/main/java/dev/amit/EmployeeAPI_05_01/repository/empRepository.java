package dev.amit.EmployeeAPI_05_01.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.amit.EmployeeAPI_05_01.entity.Employee;

public interface empRepository extends JpaRepository<Employee, Long>{

}
