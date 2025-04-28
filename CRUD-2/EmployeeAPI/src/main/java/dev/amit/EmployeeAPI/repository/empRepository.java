package dev.amit.EmployeeAPI.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.amit.EmployeeAPI.entity.Employee;

public interface empRepository  extends JpaRepository<Employee, Long>{
	

}
