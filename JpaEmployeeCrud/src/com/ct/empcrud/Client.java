package com.ct.empcrud;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Client {
	public static void main(String[] args) {

		EntityManagerFactory factory = Persistence.createEntityManagerFactory("mysql");
		EntityManager entityManager = factory.createEntityManager();// persist-->insert,merge-->update,remove,find,createQuery

		entityManager.getTransaction().begin();
//		Employee emp = new Employee(124, "naresh", 32000, "hyderabad");
//		entityManager.persist(emp);

		Employee emp = entityManager.find(Employee.class, 123);

		System.out.println(emp);

//		emp.setEmpAdd("india");
//		emp.setEmpSal(90000);
//		
//		entityManager.merge(emp);

		entityManager.remove(emp);
		entityManager.getTransaction().commit();

	}
}
