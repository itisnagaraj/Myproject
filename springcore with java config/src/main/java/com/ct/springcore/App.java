package com.ct.springcore;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.ct.springcore")
public class App {
	public static void main(String[] args) {

		ApplicationContext factory = new AnnotationConfigApplicationContext(App.class);

		Employee emp = factory.getBean("emp", Employee.class);
		System.out.println(emp);

		System.out.println(emp.getAddress());
	}

	@Bean("emp")
	public Employee getEmployee() {
		Employee emp = new Employee();
		emp.setAddress(getAddress());
		return emp;
	}

	@Bean
	public Address getAddress() {
		return new Address();
	}
}
