package com.cg.jpacrud.service;

import java.util.List;

import com.cg.jpacrud.dao.EmployeeDao;
import com.cg.jpacrud.dao.EmployeeDaoImpl;
import com.cg.jpacrud.entities.Employee;

public class EmployeeServiceImpl implements EmployeeService {
 
	
	private EmployeeDao dao;

	public EmployeeServiceImpl() {
		dao = new EmployeeDaoImpl();
	}

	@Override
	public void addEmployee(Employee employee) {
		dao.beginTransaction();
		dao.addEmployee(employee);
		dao.commitTransaction();
	}
	
	@Override
	public void updateEmployee(Employee employee) {
		dao.beginTransaction();
		dao.updateEmployee(employee);
		dao.commitTransaction();
	}
	
	@Override
	public void removeEmployee(Employee employee) {
		dao.beginTransaction();
		dao.removeEmployee(employee);
		dao.commitTransaction();
	}
	
	@Override
	public Employee findEmployeeById(int id) {
		//no need of transaction, as it's an read operation
		Employee employee  = dao.getEmployeeById(id);
		return employee;
	}

	@Override
	public List<Employee> getAllEmployee() {
		
		return dao.getAllEmployee();
	}
}
