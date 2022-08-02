package com.pdw.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class TestClient {
	public static void main(String[] args) {
		EntityManagerFactory factory = Persistence.createEntityManagerFactory("one-many");
		EntityManager em = factory.createEntityManager();
		em.getTransaction().begin();

		Vendor v = new Vendor();
		v.setVendorId(100);
		v.setVendorName("RPS");

		Customers c1 = new Customers();
		c1.setCustomerId(500);
		c1.setCustomerName("ibm");

		Customers c2 = new Customers();
		c2.setCustomerId(501);
		c2.setCustomerName("onmobile");

		Set<Customers> s = new HashSet<>();
		s.add(c1);
		s.add(c2);
	
		v.setChildren(s);
		em.persist(v);

		
//		Vendor ven = em.find(Vendor.class, 100);
//		System.out.println(ven.getVendorName());
//		System.out.println(ven.getChildren());
//		
//		
//		
////		Vendor ven = em.find(Vendor.class, 100);
////		em.remove(ven);
		
		em.getTransaction().commit();
		em.close();
		factory.close();

	}
}
