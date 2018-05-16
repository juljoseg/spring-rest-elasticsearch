package com.julio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.julio.entity.Employee;
import com.julio.service.EmployeeService;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {

	@Autowired
	private EmployeeService empService;
	
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
	public void run(String... args) throws Exception {
		this.empService.deleteAll();
		saveCustomers();
		fetchAllCustomers();
		
	}
	
	private void saveCustomers() {
		this.empService.save(new Employee("1", "Alice", "Smith"));
		this.empService.save(new Employee("2" , "Bob", "Smith"));
	}
	
	
	private void fetchAllCustomers() {
		System.out.println("Employee found with findAll():");
		System.out.println("-------------------------------");
		for (Employee e : this.empService.findAll()) {
			System.out.println(e);
		}
		System.out.println();
	}

	
}
