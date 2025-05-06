package dev.amit.EmployeeAPI_0506.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.amit.EmployeeAPI_0506.entity.Employee;

public interface empRepository  extends JpaRepository<Employee, Long>{

}
