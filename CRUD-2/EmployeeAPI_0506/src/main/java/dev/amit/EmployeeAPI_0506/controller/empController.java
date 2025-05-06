package dev.amit.EmployeeAPI_0506.controller;

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

import dev.amit.EmployeeAPI_0506.entity.Employee;
import dev.amit.EmployeeAPI_0506.repository.empRepository;

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
	
	
	@GetMapping("/employee/{EmpId}")
	public  ResponseEntity<?> findByIdEmployee(@PathVariable("EmpId") long empId) {
		
		Optional<Employee> byId = empRepository.findById(empId);
		
		if(byId.isPresent()) {
			return new ResponseEntity<>(byId, HttpStatus.FOUND);
		}
		else {
			return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
		}
		
	}
	
	
     @PutMapping("/employee/{EmpId}")
	public ResponseEntity<?> updateEmployee(@PathVariable("EmpId") long empid, @RequestBody Employee employee) {
    	 
    	 
    	 Optional<Employee> byId = empRepository.findById(empid);
    	 
    	 if(byId.isPresent()) {
    		 Employee employee2 = byId.get();
    		 
    		 employee2.setEmpCity(employee.getEmpCity());
    		 employee2.setEmpName(employee.getEmpName());
    		 empRepository.save(employee2);
    		 return new ResponseEntity<>(employee2, HttpStatus.OK);
    	 }
    	 else {
    		 
    		 return new ResponseEntity<>("Employee is not found", HttpStatus.NOT_FOUND);
    	 }
    	 
		
	}
     
     
     @DeleteMapping("/employee/{EmpId}")
     public ResponseEntity<?> deletById(@PathVariable("EmpId") long empid) {

    	 Optional<Employee> byId = empRepository.findById(empid);
    	 
    	 if(byId.isPresent()) {
    		 empRepository.deleteById(empid);
    		 return new ResponseEntity<>("Employee deleted by Id", HttpStatus.OK);
    	 }
    	 else {
    		 return new ResponseEntity<>("Employee is not found ", HttpStatus.NOT_FOUND);
    	 }
    	 
     }
     
     @DeleteMapping("/employee")
     public ResponseEntity<?> deletAllEmployee(){
    	 empRepository.deleteAll();
    	 return new ResponseEntity<>("Deleted All User ", HttpStatus.OK);
    	 
     }
	
	

}
