package com.julio.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;
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
	public void testSearchFoundEmployee() throws Exception
	{
		given(this.employeeService.findById(eq("1"))).willReturn(new Employee("10","Test","LastN"));
		
		this.mvc.perform( get("/employees/1")
						.accept(MediaType.APPLICATION_JSON))
					.andExpect(status().isOk())
					.andExpect( content().json("{ \"id\": \"10\",\"firstName\": \"Test\", \"lastName\": \"LastN\" } " ) );
		
	}
	
	
	
	
	@Test
	public void testCreateEmployee() throws Exception
	{
		when(employeeService.save(any(Employee.class))).thenReturn(new Employee("11","Name11","LastName11"));
		
		
		this.mvc.perform( post("/employees").content( toJson(new Employee("11", "Name11", "LastName11")) )
											.contentType(MediaType.APPLICATION_JSON))
		  .andExpect(status().isOk())
	      .andExpect( content().json("{ \"id\": \"11\",\"firstName\": \"Name11\", \"lastName\": \"LastName11\" } " ) );
		
	}
	
	
	
	private byte[] toJson(Object r) throws Exception {
        ObjectMapper map = new ObjectMapper();
        return map.writeValueAsString(r).getBytes();
    }
	
}
