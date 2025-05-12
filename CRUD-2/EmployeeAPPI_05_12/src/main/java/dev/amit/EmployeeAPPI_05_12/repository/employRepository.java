 package dev.amit.EmployeeAPPI_05_12.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.amit.EmployeeAPPI_05_12.entity.Employee;

public interface employRepository extends JpaRepository<Employee, Long>{

}
