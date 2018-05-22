package com.julio.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.julio.entity.Employee;

import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeServiceTest {

	
	@MockBean
	private EmployeeService employeeService;
	
	
	
	@Test
	public void saveEmployeeTest()
	{
		Employee e = new Employee("1","t1","l1");
		
		given(this.employeeService.save(e)).willReturn(e);
		
		Employee result = this.employeeService.save(e);
		
		assertThat(result).isNotNull();
		assertThat(result.getFirstName()).isEqualTo("t1");
		assertThat(result.getLastName()).isEqualTo("l1");
	}
	
	
	@Test
	public void searchEmployeeByIdTest()
	{
		List<Employee> list = new ArrayList<>(); 
				
		Employee e = new Employee("2","test","lastName");
		
		list.add(e);
		
		given(this.employeeService.findByLastName("lastName")).willReturn(list);
		
		List<Employee> result = this.employeeService.findByLastName("lastName");
		
		assertThat(result).isNotNull();
		assertThat(result.size()).isEqualTo(1);
		
	}
	
	
}
