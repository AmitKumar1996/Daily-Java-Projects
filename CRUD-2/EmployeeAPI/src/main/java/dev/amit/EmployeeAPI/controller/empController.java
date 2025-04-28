package dev.amit.EmployeeAPI.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileSystemUtils;
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
import jakarta.persistence.Entity;

@RestController
@RequestMapping("/api")
public class empController {
	@Autowired
  empRepository empRepository;
	
	@PostMapping("/employee")
	public ResponseEntity<Employee> createEmp(@RequestBody Employee employee) {
		
		System.out.println("**********"+employee);
		
		
	Employee savedEmp=	empRepository.save(employee);
	
	System.out.println("##################"+savedEmp);
		return new ResponseEntity<Employee>(savedEmp, HttpStatus.CREATED);
	}
	
	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getEmp(){
	List<Employee> all = empRepository.findAll();
		
	return new ResponseEntity<List<Employee>>(all, HttpStatus.FOUND);
		
	}
	
	@GetMapping("/employee/{empId}")
	public ResponseEntity<?> getEmpById(@PathVariable("empId") long empid) {
	    Optional<Employee> empById = empRepository.findById(empid);

	    if (empById.isPresent()) {
	        return new ResponseEntity<>(empById.get(), HttpStatus.FOUND);
	    } else {
	        return new ResponseEntity<>("Employee is not present: " + empid, HttpStatus.NOT_FOUND);
	    }
	}

	@PutMapping("/employee/{empId}")
	public ResponseEntity<?> updateEmpById(@PathVariable("empId") long empid, @RequestBody Employee employee)
	{
	Optional<Employee> empIdExist=	empRepository.findById(empid);
	if(empIdExist.isPresent()) {
		
	Employee emp=	empIdExist.get();
	emp.setEmpCity(employee.getEmpCity());
	emp.setEmpName(employee.getEmpName());
	empRepository.save(emp);
	return new ResponseEntity<>(emp, HttpStatus.OK);
	}else {
		return new ResponseEntity<>("Employee is not found "+empid,HttpStatus.NOT_FOUND);
		}
	}
	
	
	@DeleteMapping("/employee/{empId}")
	public ResponseEntity<?> deleteById(@PathVariable("empId") long empid){
		
	Optional<Employee> empDeletById=	empRepository.findById(empid);
	
	if(empDeletById.isPresent()) {
		empRepository.deleteById(empid);
		
		return new ResponseEntity<>(empDeletById, HttpStatus.OK);
	}
	else {
		
		return new ResponseEntity<>("Employee is not Present for Id :-"+empid, HttpStatus.NOT_FOUND);
		
	}
		
		
		
	}
	
	@DeleteMapping("/employee")
	public ResponseEntity<?> DeletAll() {
		if(empRepository.equals(null)) { 
			return new ResponseEntity<>("All Employee is alrady Deletd",HttpStatus.OK);
		}
		empRepository.deleteAll();
		return new ResponseEntity<>("All Employee is Deleted", HttpStatus.OK);
		
		
		
	}
	
	

}
