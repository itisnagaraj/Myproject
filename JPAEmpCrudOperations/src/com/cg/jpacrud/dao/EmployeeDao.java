package com.cg.jpacrud.dao;

import java.util.List;

import com.cg.jpacrud.entities.Employee;

public interface EmployeeDao {

	public abstract Employee getEmployeeById(int id);//find()

	public abstract void addEmployee(Employee employee);//persist()

	public abstract void removeEmployee(Employee employee);//remove()

	public abstract void updateEmployee(Employee employee);//merge()
	
	public abstract List<Employee> getAllEmployee();
	
	public abstract void commitTransaction();//getTransaction().commit()

	public abstract void beginTransaction();//getTransaction().begin()

}