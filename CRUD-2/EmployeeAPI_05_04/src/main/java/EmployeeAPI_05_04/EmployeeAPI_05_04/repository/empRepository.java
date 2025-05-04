package EmployeeAPI_05_04.EmployeeAPI_05_04.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import EmployeeAPI_05_04.EmployeeAPI_05_04.entity.Employee;

public interface empRepository extends JpaRepository<Employee, Long> {

}
