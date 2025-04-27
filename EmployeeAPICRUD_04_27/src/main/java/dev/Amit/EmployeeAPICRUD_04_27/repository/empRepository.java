package dev.Amit.EmployeeAPICRUD_04_27.repository;

import java.util.List;  // Correct import
import org.springframework.data.jpa.repository.JpaRepository;

import dev.Amit.EmployeeAPICRUD_04_27.entity.Employee;

public interface empRepository extends JpaRepository<Employee, Long> {
    
    List<Employee> findByEmpCity(String empCity);
}
