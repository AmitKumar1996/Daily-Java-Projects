package EmployeeAPI_05_04.EmployeeAPI_05_04.entity;

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
	private Long EmpId;
	
	@Column
	private String empName;
	
	@Column
	private String empCity;
	
	@Column
	private   double salary;

	public Long getEmpId() {
		return EmpId;
	}

	public void setEmpId(Long empId) {
		EmpId = empId;
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
		return "Employee [EmpId=" + EmpId + ", empName=" + empName + ", empCity=" + empCity + ", salary=" + salary
				+ "]";
	}

	public Employee(Long empId, String empName, String empCity, double salary) {
		super();
		EmpId = empId;
		this.empName = empName;
		this.empCity = empCity;
		this.salary = salary;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
