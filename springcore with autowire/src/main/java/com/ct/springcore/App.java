package com.ct.springcore;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

public class App {
	public static void main(String[] args) {

		Resource resource = new ClassPathResource("springconfig.xml");
		BeanFactory factory = new XmlBeanFactory(resource);
		Employee emp = factory.getBean("emp", Employee.class);
		System.out.println(emp);
		System.out.println(emp.getAddress());
	}
}
