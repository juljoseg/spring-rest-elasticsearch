package com.julio.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document(indexName = "demo", type = "employee")
public class Employee {
	
	@Id
    private String id;
    private String firstName;
    private String lastName;
     
    
    @JsonCreator
	public Employee(@JsonProperty("id") String id, 
			@JsonProperty("firstName")String firstName, 
			@JsonProperty("lastName")String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
    
    
	

}
