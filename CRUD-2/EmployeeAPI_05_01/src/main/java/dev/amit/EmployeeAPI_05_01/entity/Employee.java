package dev.amit.EmployeeAPI_05_01.entity;

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
	private long id;
	@Column
	private String empName;
	@Column
	private String empCity;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
	@Override
	public String toString() {
		return "Employee [id=" + id + ", empName=" + empName + ", empCity=" + empCity + "]";
	}
	public Employee(long id, String empName, String empCity) {
		super();
		this.id = id;
		this.empName = empName;
		this.empCity = empCity;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}

