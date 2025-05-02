package dev.amit.EmployeeAPI_05_02.entity;

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
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private Long Empid;
	
	@Column
	private String EmpName;
	
	@Column
	private String empCity;

	public Long getEmpid() {
		return Empid;
	}

	public void setEmpid(Long empid) {
		Empid = empid;
	}

	public String getEmpName() {
		return EmpName;
	}

	public void setEmpName(String empName) {
		EmpName = empName;
	}

	public String getEmpCity() {
		return empCity;
	}

	public void setEmpCity(String empCity) {
		this.empCity = empCity;
	}

	@Override
	public String toString() {
		return "Employee [Empid=" + Empid + ", EmpName=" + EmpName + ", empCity=" + empCity + "]";
	}

	public Employee(Long empid, String empName, String empCity) {
		super();
		Empid = empid;
		EmpName = empName;
		this.empCity = empCity;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
}
