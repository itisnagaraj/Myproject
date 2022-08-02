package com.cg.jpacrud.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "sleepingemps")//select eid from ibmemp;//sql--database depenedent query
public class Employee  {  //select employeeId from Employee;//JPQL database indepenedent query
	@Id
	@Column(name="eid",length=12)
	private int employeeId;
	@Column(name="ename",length=12)
	private String empName;
	@Column(name = "salary")
	private int empSal;
	@Column(name="eadd",length=12)
	private String address;

	public Employee() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Employee [employeeId=" + employeeId + ", empName=" + empName + ", empSal=" + empSal + ", address="
				+ address + "]";
	}

	public Employee(int employeeId, String empName, int empSal, String address) {
		super();
		this.employeeId = employeeId;
		this.empName = empName;
		this.empSal = empSal;
		this.address = address;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public int getEmpSal() {
		return empSal;
	}

	public void setEmpSal(int empSal) {
		this.empSal = empSal;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
