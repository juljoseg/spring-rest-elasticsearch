package com.julio.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.julio.controller.EmployeeControler;
import com.julio.entity.Employee;
import com.julio.service.EmployeeService;


import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringRunner.class)
@WebMvcTest(EmployeeControler.class)
public class EmployeeControlerTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private EmployeeService employeeService;
	
	
	@Test
	public void testSearchEmployee() throws Exception
	{
		given(this.employeeService.findById("1")).willReturn(new Employee("10","Test","LastN"));
		this.mvc.perform( get("/employees/1").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()).andExpect( content().json("{ \"id\": \"10\",\"firstName\": \"Test\", \"lastName\": \"LastN\" } " ) );
		
	}
	
	
}
