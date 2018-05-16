package com.julio.repository;

import java.util.List;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.julio.entity.Employee;


public interface EmployeeRepository extends ElasticsearchRepository<Employee, String> {

	
	  List<Employee> findByLastName(String lastName);
	
}
