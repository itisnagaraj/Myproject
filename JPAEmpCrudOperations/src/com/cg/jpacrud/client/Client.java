package com.cg.jpacrud.client;

import java.util.List;

import com.cg.jpacrud.entities.Employee;
import com.cg.jpacrud.service.EmployeeService;
import com.cg.jpacrud.service.EmployeeServiceImpl;

public class Client {

	public static void main(String[] args) {
			//UI<--->service<--->dao
		//Debug this program as Debug -> Debug as Java Application
		
		EmployeeService service = new EmployeeServiceImpl();//object injection
		
		Employee employee = new Employee(123,"smita",100000, "mumbai");//new /transient
		Employee employee1 = new Employee(124,"kajal",500000, "hyd");
		Employee employee2 = new Employee(125,"kriti",20000, "banglore");
					service.addEmployee(employee);//persist-->managed/persistent state 
					service.addEmployee(employee1);
					service.addEmployee(employee2);
					
		//at this breakpoint, we have added one record to table
		employee = service.findEmployeeById(123);//find(Employee.class,123)
		System.out.print("ID:"+employee.getEmployeeId());
		System.out.println(" Name:"+employee.getEmpName());
		System.out.println("salary :"+employee.getEmpSal());
		
		employee.setEmpName("akash");
		employee.setAddress("hyderabad");
		service.updateEmployee(employee);//merge
		
		//at this breakpoint, we have updated record added in first section
		employee = service.findEmployeeById(123);//select *from emp where eid=123;
		System.out.print("ID:"+employee.getEmployeeId());
		System.out.println(" Name:"+employee.getEmpName());
		System.out.println(" Location"+employee.getAddress());
		//at this breakpoint, record is removed from table
		
	List<Employee> emps=	service.getAllEmployee();
//		for(Employee emp:emps)
//		{
//			System.out.println(emp);
//		}
		emps.forEach(System.out::println);
		
		service.removeEmployee(employee);
		System.out.println("End of program...");
		
		//JPQL-->Query's
		
		//JPA--->persist,find,merge,remove	
	}
}
