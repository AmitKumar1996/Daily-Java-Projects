package dev.amit.EmployeeAPI.entity;

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
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long empId;
	
	@Column
	
	private String empName;
	
	
	@Column
	private String empCity;
	
	
	private double salary;


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


	public double getSalary() {
		return salary;
	}


	public void setSalary(double salary) {
		this.salary = salary;
	}


	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empCity=" + empCity + ", salary=" + salary
				+ "]";
	}


	public Employee(Long empId, String empName, String empCity, double salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empCity = empCity;
		this.salary = salary;
	}


	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	

}
