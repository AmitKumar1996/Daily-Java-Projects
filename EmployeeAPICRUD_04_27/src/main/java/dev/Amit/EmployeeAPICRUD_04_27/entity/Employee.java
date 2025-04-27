package dev.Amit.EmployeeAPICRUD_04_27.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table
public class Employee {

@Id
@GeneratedValue(strategy= GenerationType.AUTO)
@Column
private Long empId;
@Column
private String empName;
@Column
private String empCity;
@Column
private String empEmail;





public Employee(Long empId, String empName, String empCity, String empEmail) {
	super();
	this.empId = empId;
	this.empName = empName;
	this.empCity = empCity;
	this.empEmail = empEmail;
}
public Employee() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "Employee [empId=" + empId + ", empName=" + empName + ", empCity=" + empCity + ", empEmail=" + empEmail
			+ "]";
}
public Long getEmpId() {
	return empId;
}
public void setEmpId(Long empId) {
	this.empId = empId;
}
public String getEmpName() {
	return empName;
}
public void setEmpName(String empName) {
	this.empName = empName;
}
public String getEmpCity() {
	return empCity;
}
public void setEmpCity(String empCity) {
	this.empCity = empCity;
}
public String getEmpEmail() {
	return empEmail;
}
public void setEmpEmail(String empEmail) {
	this.empEmail = empEmail;
}



}
