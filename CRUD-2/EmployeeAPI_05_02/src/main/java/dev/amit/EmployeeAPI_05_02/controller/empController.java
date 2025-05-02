package dev.amit.EmployeeAPI_05_02.controller;

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

import dev.amit.EmployeeAPI_05_02.entity.Employee;
import dev.amit.EmployeeAPI_05_02.repository.empRepository;

@RestController
@RequestMapping("/api")
public class empController {
	
	@Autowired
	empRepository empRepository;
	
	
	@PostMapping("/employee")
	public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
		System.out.println("h1");
		
	Employee createEmployee=empRepository.save(employee);
	System.out.println("h2");
		
		return new ResponseEntity<>(createEmployee, HttpStatus.CREATED);
		
	}
	
	@GetMapping("/employee")
	public ResponseEntity<?> getEmployee(){
		
		
		
		return new ResponseEntity<>(empRepository.findAll(), HttpStatus.FOUND);
	}
	
	
	@GetMapping("/employee/{EmpId}")
	public ResponseEntity<?> getEmployeeById(@PathVariable("EmpId") long empid){
		
		return new ResponseEntity<>(empRepository.findById(empid), HttpStatus.FOUND);
		
	}
	
	@PutMapping("/employee/{empId}")
	public ResponseEntity<?> updateEmployee(@PathVariable("empId") long id, @RequestBody Employee employee ){
Optional<Employee> findById=empRepository.findById(id);

if(findById.isPresent()) {
 Employee  updatedEmployee= findById.get();
 
 updatedEmployee.setEmpCity(employee.getEmpCity());
 updatedEmployee.setEmpName(employee.getEmpName());
 empRepository.save(updatedEmployee);
		
		return new ResponseEntity<>(updatedEmployee, HttpStatus.CREATED);
}
else {
	return new ResponseEntity<>("Id not found", HttpStatus.NOT_FOUND);
}
		
	}
	
	@DeleteMapping("/employee/{EmpId}")
	public ResponseEntity<?> deletedEmployee(@PathVariable("EmpId") long id) {

Optional<Employee> deletEmp=empRepository.findById(id);

        if(deletEmp.isPresent()) {
        	empRepository.deleteById(id);
        	return new ResponseEntity<>("Deleted", HttpStatus.OK);
        }
        else {
        	return new ResponseEntity<>("Id not present "+id, HttpStatus.NOT_FOUND);
        }
		
		
	}
	
	@DeleteMapping("/employee")
	public ResponseEntity<?> deletAllEmp(){
		empRepository.deleteAll();
		return new ResponseEntity<>("Deleted All Employee", HttpStatus.OK);
		
	}

}
