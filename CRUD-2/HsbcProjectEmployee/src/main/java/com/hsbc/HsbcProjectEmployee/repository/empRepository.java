package com.hsbc.HsbcProjectEmployee.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hsbc.HsbcProjectEmployee.entity.Employee;

public interface empRepository extends JpaRepository<Employee, Long> {

	List<Employee> findByEmpCity(String city);

}
