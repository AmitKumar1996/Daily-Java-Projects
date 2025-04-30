package dev.amit.EmployeeAPI_04_29.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.amit.EmployeeAPI_04_29.entity.Employee;
import dev.amit.EmployeeAPI_04_29.repository.employeeRepository;

@RestController
@RequestMapping("/amit")

public class employeeController {
	
	
	@Autowired
	employeeRepository employeeRepository;
	
	
	
	
	
	
//	@PostMapping("/sumit")
//	public String createEmp(@RequestBody Employee  employee ) {
//		
//		
//		employeeRepository.save(employee);
//		
//		return "Data is saved";
//		
//	}
	
	
	
	
	@PostMapping("/employee")
	public ResponseEntity<?> createEmployee(@RequestBody Employee employee ){
		 
	Employee emp=	employeeRepository.save(employee);
		
		return new ResponseEntity<>("Employee created "+emp, HttpStatus.CREATED);
	}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/employee")
	public ResponseEntity<?> getEmployee(){
	List<Employee> allEmp=	employeeRepository.findAll();
	
	System.err.println(allEmp);
		
		return new ResponseEntity<>(allEmp, HttpStatus.OK);
	}
	
	
	@GetMapping("/employee/{EmpId}")
	public ResponseEntity<?> getEmpById(@PathVariable("EmpId") long empid){
		Optional<Employee> empById=employeeRepository.findById(empid);
		
		if(empById.isPresent()) {
			return new ResponseEntity<>(empById, HttpStatus.FOUND);
		}else {
			return new ResponseEntity<>("Employee Is Not present in DB By This Employee Id "+empid, HttpStatus.NOT_FOUND);
		}
		
	}
	
	@PutMapping("/employee/{EmpId}")
	public ResponseEntity<?> updateEmployeeById(@PathVariable("EmpId") long empid, @RequestBody Employee employee){
		
	Optional<Employee> foundEmp=employeeRepository.findById(empid);
	
	System.out.println("Hi1");
	
	if(foundEmp.isPresent()) {
		System.out.println("Hi2");
		
	 Employee emp = foundEmp.get();
	    
	    emp.setEmpCity(employee.getEmpCity());
	    emp.setEmpName(employee.getEmpName());
	    
	    System.out.println("Hi3");
	    
	  Employee UpdatedEmp = employeeRepository.save(emp);
	    
	  System.out.println("Hi4");
	    return new ResponseEntity<>(UpdatedEmp, HttpStatus.OK);
		
	}
	else {
		return new ResponseEntity<>("User Not exist in DB", HttpStatus.NOT_FOUND);
	}
		
	
		
	}
	
	@DeleteMapping("/employee/{Id}")
	public ResponseEntity<?> deleteById(@PathVariable("Id") long id) {
	
	Optional<Employee>  emp=	employeeRepository.findById(id);
	
	if(emp.isPresent()) {
		employeeRepository.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}else {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	}
		
	
	@DeleteMapping("/employee")
  public ResponseEntity<?> deleteAll(){
	List<Employee> allEmp=	employeeRepository.findAll();
	
	if(allEmp.isEmpty()) {
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
		employeeRepository.deleteAll();
		return new ResponseEntity<>(HttpStatus.OK);
	  
  
		
		
	}
}
