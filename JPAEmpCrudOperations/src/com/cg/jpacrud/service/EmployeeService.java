package com.cg.jpacrud.service;

import java.util.List;

import com.cg.jpacrud.entities.Employee;

public interface EmployeeService {

	public abstract void addEmployee(Employee employee);//persist();

	public abstract void updateEmployee(Employee employee);//merge()

	public abstract void removeEmployee(Employee employee);//remove()

	public abstract Employee findEmployeeById(int id);//find()
	
	public abstract List<Employee> getAllEmployee();//createQuery()---->getTransaction(),begin(),commit()
}