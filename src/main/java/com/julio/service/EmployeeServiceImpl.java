package com.julio.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julio.entity.Employee;
import com.julio.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	
	
	@Autowired
	private EmployeeRepository employeeRepository;
	
	
	public Employee save(Employee employee) {
		return  employeeRepository.save(employee) ;
	}

	public void delete(Employee employee) {
		employeeRepository.delete(employee);
	}

	public Iterable<Employee> findAll() {
		return employeeRepository.findAll();
	}

	public List<Employee> findByLastName(String lastName) {
		return employeeRepository.findByLastName(lastName);
	}

	public Employee findById(String id) {
		return employeeRepository.findById(id).orElse(null);
	}

	public void deleteAll() {
		employeeRepository.deleteAll();
	}
	
	public void deleteById(String id) {
		employeeRepository.deleteById(id);
	}
	

}
