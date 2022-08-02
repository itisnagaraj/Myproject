package com.cg.jpacrud.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.cg.jpacrud.entities.Employee;

public class EmployeeDaoImpl implements EmployeeDao {

	private EntityManager entityManager;//insert  --->persist,merge,remove,find,createQuery

	public EmployeeDaoImpl() {
		entityManager = JPAUtil.getEntityManager();
	}

//persist -saving,remove-delete,find,merge
	@Override
	public Employee getEmployeeById(int id) {
		Employee employee = entityManager.find(Employee.class, id);//select * from tname where eid=123
		return employee;
	}

	@Override
	public void addEmployee(Employee employee) {
		entityManager.persist(employee);
	}

	@Override
	public void removeEmployee(Employee employee) {
		entityManager.remove(employee);
	}

	@Override
	public void updateEmployee(Employee employee) {
		entityManager.merge(employee);
	}

	@Override
	public void beginTransaction() {
		entityManager.getTransaction().begin();
	}

	@Override
	public void commitTransaction() {
		entityManager.getTransaction().commit();
	}

	@Override
	public List<Employee> getAllEmployee() {

		TypedQuery<Employee> employees = entityManager.createQuery("select e from Employee e", Employee.class);
		List<Employee> listOfEmps=employees.getResultList();
		return listOfEmps;//select * from cgemp
	}
}
