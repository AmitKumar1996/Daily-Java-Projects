package EmployeeAPI_05_04.EmployeeAPI_05_04.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import EmployeeAPI_05_04.EmployeeAPI_05_04.entity.Employee;
import EmployeeAPI_05_04.EmployeeAPI_05_04.repository.empRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/api")

public class employeeController {
	
	@Autowired
	empRepository empRepository;
	
	
	
@PostMapping("/employee")
public ResponseEntity<?> postMethodName(@RequestBody Employee employee) {
Employee emp=	empRepository.save(employee);
	
    return new ResponseEntity<>(emp, HttpStatus.CREATED);
}


@GetMapping("/employee")
public ResponseEntity<?> getEmployee(){
	
	
	return new ResponseEntity<>(empRepository.findAll(), HttpStatus.FOUND);
	
}

@GetMapping("/employee/{EmpId}")
public ResponseEntity<?> getById(@PathVariable("EmpId") long empid){
	
	
	return new ResponseEntity<>(empRepository.findById(empid), HttpStatus.FOUND);
}


@PostMapping("/employee/{EmpId}")
public  ResponseEntity<?> updateEmployee(@PathVariable("EmpId") long empid, @RequestBody Employee employee) {
	
Optional<Employee> empl=	empRepository.findById(empid);

if(empl.isPresent()) {
	
Employee emp=	empl.get();

emp.setEmpCity(employee.getEmpCity());
emp.setEmpName(employee.getEmpName());
emp.setSalary(employee.getSalary());
empRepository.save(emp);
	
	return new ResponseEntity<>(emp, HttpStatus.OK);
}
else {
	return new ResponseEntity<>("Employee not found", HttpStatus.NOT_FOUND);
}

}

@DeleteMapping("/employee/{EmpId}")
public ResponseEntity<?> empDeletedById(@PathVariable("EmpId") long empid, @RequestBody Employee employee) {
	
Optional<Employee> emp=	empRepository.findById(empid);

if(emp.isPresent()) {
	
      empRepository.deleteById(empid);
	return new ResponseEntity<>(emp.get(), HttpStatus.OK);
}
else {
	return new ResponseEntity<>("Employee not Found : "+empid, HttpStatus.OK);
}

}

@DeleteMapping("/employee")
public ResponseEntity<?> deletAllEmployee(){
	
	empRepository.deleteAll();
	
	return new ResponseEntity<>("All Employee Deleted ", HttpStatus.OK);
	
	
}

}



