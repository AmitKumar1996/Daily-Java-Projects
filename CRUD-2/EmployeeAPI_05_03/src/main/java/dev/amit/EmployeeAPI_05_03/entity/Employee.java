package dev.amit.EmployeeAPI_05_03.entity;

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
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long empId;
	
	@Column
	private String EmpName;
	
	@Column
	private String EmpCity;

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return EmpName;
	}

	public void setEmpName(String empName) {
		EmpName = empName;
	}

	public String getEmpCity() {
		return EmpCity;
	}

	public void setEmpCity(String empCity) {
		EmpCity = empCity;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", EmpName=" + EmpName + ", EmpCity=" + EmpCity + "]";
	}

	public Employee(Long empId, String empName, String empCity) {
		super();
		this.empId = empId;
		EmpName = empName;
		EmpCity = empCity;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
