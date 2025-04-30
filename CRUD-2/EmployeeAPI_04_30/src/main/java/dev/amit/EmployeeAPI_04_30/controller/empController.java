package dev.amit.EmployeeAPI_04_30.controller;

import java.lang.foreign.Linker.Option;
import java.net.http.HttpClient;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.amit.EmployeeAPI_04_30.entity.Employee;
import dev.amit.EmployeeAPI_04_30.repository.empRepository;

@RestController
@RequestMapping("/api")

public class empController {
	@Autowired
    empRepository empRepository;
	
	@PostMapping("/employee")
	public ResponseEntity<?> createEmp(@RequestBody Employee employee){
		
	Employee saveEmp=	empRepository.save(employee);
		
	
		
		return new ResponseEntity<>(saveEmp, HttpStatus.CREATED);
		
		
	}
       
	
	@GetMapping("/employee")
	public ResponseEntity<?> getEmp(){

	List<Employee> allEmp=	empRepository.findAll();
	
	
		
		return new ResponseEntity<>(allEmp, HttpStatus.OK);
	}
	
	
	@GetMapping("/employee/{Id}")
	public ResponseEntity<?> empGetById(@PathVariable("Id") long id){
		
		
	Optional<Employee>	 empById=empRepository.findById(id);
	
	if(empById.isPresent()) {
		return new ResponseEntity<>(empById.get(), HttpStatus.FOUND);
	}
	else {
		return new ResponseEntity<>("Employee is not present in DB "+ id, HttpStatus.NOT_FOUND);
	}
		
	
		
		
	}
	
	
	
	@PutMapping("/employee/{EmpId}")
	public  ResponseEntity<?> updateProduct(@PathVariable("EmpId") long id, @RequestBody Employee employee){
		
		
	Optional<Employee> empById=	empRepository.findById(id);
	
	if(empById.isPresent()) {
	Employee newEmp=	empById.get();
	
	newEmp.setEmpName(employee.getEmpName());
	newEmp.setEmpCity(employee.getEmpCity());
	empRepository.save(newEmp);
	
	return new ResponseEntity<>(newEmp, HttpStatus.UPGRADE_REQUIRED);
	
	}
	else {
		return new ResponseEntity<>("This Id "+ id+" is not present In DB", HttpStatus.NOT_FOUND);
	}
		
	
		
	}
	
	@DeleteMapping("/employee/{empId}")
	public ResponseEntity<?> deletEmpById(@PathVariable("empId") long empid){
		
		empRepository.deleteById(empid);
		
		return new ResponseEntity<>("Employee is Deleted for this Id: "+empid, HttpStatus.OK);
		
		
		
	}
	
	@DeleteMapping("/employee")
	
	public ResponseEntity<?>deleteAll(){
		return new ResponseEntity<>("Delete All Employee in DB", HttpStatus.OK);
	}
}
