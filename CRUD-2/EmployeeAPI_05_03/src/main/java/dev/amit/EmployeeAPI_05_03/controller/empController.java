package dev.amit.EmployeeAPI_05_03.controller;

import java.net.ResponseCache;
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

import dev.amit.EmployeeAPI_05_03.entity.Employee;
import dev.amit.EmployeeAPI_05_03.repository.empRepository;

@RestController
@RequestMapping("/api")
public class empController {
	
	@Autowired
	empRepository empRepository;
	
	
	@PostMapping("/employee")
	public ResponseEntity<?> createUser(@RequestBody Employee employee){
		
		System.out.println("hi1");
		
	Employee emp=	empRepository.save(employee);
	System.out.println(emp);
		
		
		return new ResponseEntity<>(emp, HttpStatus.CREATED);

		
	}
	
	
	@GetMapping("/employee")
	public ResponseEntity<?> getEmployee(){
		
		return new ResponseEntity<>(empRepository.findAll(),HttpStatus.OK);
		
	}

	@GetMapping("/employee/{empId}")
	public ResponseEntity<?> getEmployeeById(@PathVariable("empId") long empid){
		
	Optional<Employee> emp=	empRepository.findById(empid);
		
	if(emp.isPresent()) {
		return new ResponseEntity<>(emp.get(),HttpStatus.FOUND);
	}
	else {
		return new ResponseEntity<>(empid+" is not found", HttpStatus.NOT_FOUND);
	}

	
		
	}
	
	
	  @PutMapping("/employee/{empId}") 
	  public ResponseEntity<?> updateEmployee(@PathVariable("empId") long empid, @RequestBody Employee employee){
		Optional<Employee> emplo =empRepository.findById(empid);
		
		if(emplo.isPresent()) {
		        Employee updEmp=emplo.get();
		        
		        updEmp.setEmpCity(employee.getEmpCity());
		        updEmp.setEmpName(employee.getEmpName());
		        empRepository.save(updEmp);
		        return new ResponseEntity<>(updEmp, HttpStatus.OK);
		}
		else {
			return new ResponseEntity<>("Employee Not Found", HttpStatus.NOT_FOUND);
		}

		
	}
		
	  @DeleteMapping("/employee")
	  public ResponseEntity<?> deletEmployee(){
		  return new ResponseEntity<>("DeletAll Employee", HttpStatus.OK);
	  }
	
      @DeleteMapping("/employee/{empId}")
	  public ResponseEntity<?> DeletById(@PathVariable("empId") long empid){
    	  
    Optional<Employee> empi=	  empRepository.findById(empid);
    
    if(empi.isPresent()) {
    empRepository.deleteById(empid);
    return new ResponseEntity<>("Employee Deleted by Id "+empi.get(), HttpStatus.OK);
    }
    else {
    	return new ResponseEntity<>("Employee not found :- "+empid, HttpStatus.OK);
    }
    	 
      }
}
