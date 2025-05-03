package dev.amit.EmployeeAPI_05_03.controller;

import java.net.ResponseCache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.amit.EmployeeAPI_05_03.entity.Employee;
import dev.amit.EmployeeAPI_05_03.repository.empRepository;

@RestController
@RequestMapping("/api")
public class empController {
	
	@Autowired
	empRepository empRepository;
	
	
	@PutMapping("/employee")
	public ResponseEntity<?> createUser(@RequestBody Employee employee){
		
		empRepository.save(employee);
		
		
		return new ResponseEntity<>("Employee created"+employee, HttpStatus.CREATED);
		
		
		
	}

}
