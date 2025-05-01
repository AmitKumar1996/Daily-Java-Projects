package dev.amit.EmployeeAPI_05_01.controller;

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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import dev.amit.EmployeeAPI_05_01.entity.Employee;
import dev.amit.EmployeeAPI_05_01.repository.empRepository;

@RestController
@RequestMapping("/api")
public class empController {
	
	@Autowired
	empRepository empRepository;
	
	
	@PostMapping("/employee")
	public ResponseEntity<Employee> createEmp(@RequestBody Employee employee){
		
	Employee emp=	empRepository.save(employee);
		
		
		
		return new ResponseEntity<>(emp, HttpStatus.CREATED);
	}
	
	
	@GetMapping("/employee")
	public ResponseEntity<List<Employee>> getEmployee(){
	List<Employee> allEmp=	empRepository.findAll();	
		return new ResponseEntity<List<Employee>>(allEmp, HttpStatus.ACCEPTED);
	}

	
	@GetMapping("/employee/{EmpId}")
	public ResponseEntity<?> getById(@PathVariable("EmpId") long empid, @RequestBody Employee employee ){
	Optional<Employee> empById=empRepository.findById(empid);
	
	if(empById.isPresent()) {
		return new ResponseEntity<>(empById.get(), HttpStatus.CREATED);
	}
	else {
		return new ResponseEntity<>("User is not exist", HttpStatus.NOT_FOUND);
	}
	
   }	
	@PutMapping("/employee/{Empid}")
	public ResponseEntity<?> userUpdate(@PathVariable("Empid") long empid, @RequestBody Employee employee) {
      Optional<Employee> emp=empRepository.findById(empid);
		
		 if(emp.isPresent()) {
	
			Employee updateEmp= emp.get();
			updateEmp.setEmpCity(employee.getEmpCity());
			updateEmp.setEmpName(employee.getEmpName());
			empRepository.save(updateEmp);
			
			return new ResponseEntity<>("Employee Updated" , HttpStatus.OK);
			 
			 
		 }
		 else {
			 return  new ResponseEntity<>("Employee Not Found ", HttpStatus.NOT_FOUND);
		 }
		
		
	}

	
	
	@DeleteMapping("/employee/{EmpId}")
    public ResponseEntity<?> deleteById(@PathVariable("EmpId")  long empid) {
		
Optional<Employee> empId=empRepository.findById(empid);
if(empId.isPresent()) {
	empRepository.deleteById(empid);
	return new ResponseEntity<>("Deleted", HttpStatus.OK);
}
else {
	return new ResponseEntity<>("ID Not Found", HttpStatus.NOT_FOUND);
	
}
		
}
	
	@DeleteMapping("/employee")
	public  ResponseEntity<?> deletEmp(){
		
		empRepository.deleteAll();
		
		return new ResponseEntity<>("All Employee is Deleted", HttpStatus.OK);
	}	
    



}
