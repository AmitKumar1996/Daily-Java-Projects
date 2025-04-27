package dev.Amit.EmployeeAPICRUD_04_27.controller;

import java.util.ArrayList;
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

import dev.Amit.EmployeeAPICRUD_04_27.entity.Employee;
import dev.Amit.EmployeeAPICRUD_04_27.repository.empRepository;

@RestController
@RequestMapping("/api")
public class empController {
	
	@Autowired
	empRepository empRepository;
	
	@PostMapping("/employee")
	public Employee createEmp(@RequestBody Employee employee) {
		
		empRepository.save(employee);
		
		
		return employee;
	}
	
	
	
	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getEmployee(){
		
	List<Employee> emplist = new ArrayList<>();
	
	empRepository.findAll().forEach(emplist :: add);
	
	return new ResponseEntity<List<Employee>>(emplist, HttpStatus.OK);
	
	}
	
	
	@GetMapping("/employee/{empId}")
	
	public ResponseEntity<Employee> getEmployeeById(@PathVariable long empId ){
		
	Optional<Employee> emp=	empRepository.findById(empId);
	  if(emp.isPresent()) {
		  return new ResponseEntity<Employee>(emp.get(),HttpStatus.FOUND);
	  }
		
		return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
		
		
	}
	
	
	@PutMapping("/employee/{id}")
	public ResponseEntity<Employee> updateEmployeeByID(@PathVariable("id") long empId, @RequestBody Employee employee) {

	    Optional<Employee> empUpdate = empRepository.findById(empId);

	    if (empUpdate.isPresent()) {
	        Employee existEmp = empUpdate.get();

	        existEmp.setEmpCity(employee.getEmpCity());
	        existEmp.setEmpEmail(employee.getEmpEmail());
	        existEmp.setEmpName(employee.getEmpName());

	        Employee updatedEmp = empRepository.save(existEmp);

	        return new ResponseEntity<Employee>(updatedEmp, HttpStatus.OK);
	    } else {
	        return new ResponseEntity<Employee>(HttpStatus.NOT_FOUND);
	    }
	}
	
	@DeleteMapping("/employee/{empId}")
	
	public ResponseEntity<String> deleteById(@PathVariable("empId") long empid){
		
	Optional<Employee> existEmp=	empRepository.findById(empid);
	if(existEmp.isPresent()) {
		empRepository.deleteById(empid);
		
	//Employee emp=	empRepository.findById(existEmp);
		return new ResponseEntity<>("Employee " +empid+ " is deleted", HttpStatus.OK);
	}
	else {
		return new ResponseEntity<>("Employee is not present with this Id "+empid, HttpStatus.NOT_FOUND);
	}
	
	}
	
	@DeleteMapping("/employee")
	public ResponseEntity<String> deleteAllEmp() {
		
		empRepository.deleteAll();
		
		return new ResponseEntity<>("All Employee is Deleted",HttpStatus.OK);
		
	}
	
	
	@GetMapping("/employee/{City}")
	public ResponseEntity<List<Employee>> findEmpByCity(@PathVariable("City") String city) {
	    // Fetch employees by city
	    List<Employee> empByCity = empRepository.findByEmpCity(city);
	    
	    // Check if employees are found
	    if (empByCity.isEmpty()) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);  // Return 404 if no employees are found
	    } else {
	        return new ResponseEntity<>(empByCity, HttpStatus.OK);  // Return the list with 200 status if employees are found
	    }
	}

	
}

