package com.julio.service;

import java.util.List;

import com.julio.entity.Employee;

public interface EmployeeService {

	Employee save(Employee employee);
	
	void delete(Employee employee);
	
	Iterable<Employee> findAll();
	
	List<Employee> findByLastName(String lastName);
	
	Employee findById(String id);
	
	void deleteAll();
	
	void deleteById(String id);
	
}
