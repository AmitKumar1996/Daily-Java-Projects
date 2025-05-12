package dev.amit.EmployeeAPPI_05_12.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.amit.EmployeeAPPI_05_12.entity.Employee;
import dev.amit.EmployeeAPPI_05_12.repository.employRepository;

@RestController
@RequestMapping("/api")
public class empController {
	
	@Autowired
	employRepository employRepository;
	
	@PostMapping("/employee")
	public RequestEntity<?> createEmployee(@RequestBody Employee employee){
		
		Employee save = employRepository.save(employee);
		return new RequestEntity<>(save, HttpStatus.FOUND);
		
	}

}
