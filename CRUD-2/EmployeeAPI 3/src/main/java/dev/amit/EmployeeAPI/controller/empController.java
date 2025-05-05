package dev.amit.EmployeeAPI.controller;

import java.net.http.HttpClient;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dev.amit.EmployeeAPI.entity.Employee;
import dev.amit.EmployeeAPI.repository.empRepository;

@RestController
@RequestMapping("/api")
public class empController {
	
	@Autowired
	empRepository empRepository;
	
	@PostMapping("/employee")
	public ResponseEntity<?> createEmployee(@RequestBody Employee employee){
		
		Employee save = empRepository.save(employee);
		return new ResponseEntity<>(save, HttpStatus.OK);
	}
	
	@GetMapping("/employee")
	public ResponseEntity<?> getEmployee(){
		
		List<Employee> all = empRepository.findAll();
		
		return new ResponseEntity<>(all, HttpStatus.FOUND);
		
	}
	
	@GetMapping("/employee/{empId}")
	public ResponseEntity<?> getEmployee(@PathVariable("empId") long empid){
		
		
		Optional<Employee> byId = empRepository.findById(empid);
		
		if(byId.isPresent()) {
			return new ResponseEntity<>(byId.get(), HttpStatus.OK);
			
		}
		else {
			return new ResponseEntity<>("Employee Not Found : "+empid, HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	
	@PutMapping("/employee/{EmpId}")
	public ResponseEntity<?> updateEmployee(@PathVariable("EmpId") long empId, @RequestBody Employee employee
			) {
	          Optional<Employee> byId = empRepository.findById(empId);
			
			
	          if(byId.isPresent()) {
	        	  Employee employee2 = byId.get();
	        	  employee2.setEmpCity(employee.getEmpCity());
	        	  employee2.setEmpName(employee.getEmpName());
	        	  employee2.setSalary(employee.getSalary());
	        	  empRepository.save(employee2);
	        	  return new ResponseEntity<>(employee2, HttpStatus.OK);
	        
	          }
	          else {
	        	  return new ResponseEntity<>("Employee Not Found", HttpStatus.NOT_FOUND);
	          }
		
		
		
	}
	
	@DeleteMapping("/employee/{EmpId}")
	public  ResponseEntity<?> deletEmployee(@PathVariable("EmpId") long empbyId){
		
		
		Optional<Employee> byId = empRepository.findById(empbyId);
		
		if(byId.isPresent()) {
			empRepository.deleteById(empbyId);
			return new ResponseEntity<>( "Employee Deleted by Id:- "+empbyId, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Employee Not Deleted: "+empbyId, HttpStatus.NOT_FOUND);
		}
		
		
	}
	
	@DeleteMapping("/employee")
	public ResponseEntity<?> deletAllEmployee() {
		
	empRepository.deleteAll();
	return new ResponseEntity<>("All Employee deleted", HttpStatus.OK);
		
	}

}
