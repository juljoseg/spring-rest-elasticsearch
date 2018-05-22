package com.julio.controller;



import java.net.URI;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.julio.entity.Employee;
import com.julio.service.EmployeeService;

@CrossOrigin
@RestController
public class EmployeeControler {

	
	@Autowired
	EmployeeService employeeService;
	
	
	@RequestMapping(method=RequestMethod.GET,value="/employees")
	public List<Employee> getAllEmployees()
	{
		List<Employee> employees = new ArrayList<>();
		employeeService.findAll().forEach(c -> employees.add(c));
		
		return employees ;
	}
	
	
	@RequestMapping(method=RequestMethod.GET,value="/employees/{id}")
	public Employee getEmployee(@PathVariable String id)
	{
		return employeeService.findById(id) ;
	}
	
	@RequestMapping(method=RequestMethod.DELETE,value="/employees/{id}")
	public void deleteEmployee(@PathVariable String id)
	{
		employeeService.deleteById(id) ;
	}
	
	@RequestMapping(method=RequestMethod.POST,value="/employees")
	public Employee saveEmployee(@RequestBody Employee employee)
	{
		return employeeService.save(employee);
	}
	
	
	@RequestMapping(method=RequestMethod.DELETE,value="/employees")
	public void deleteAllEmployee()
	{
		employeeService.deleteAll(); ;
	}
	
}
