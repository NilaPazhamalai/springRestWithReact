package com.nila.springRestWithReact.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Employee {
	
	@Id
	@GeneratedValue
	private Long id;
	private String firstName;
	private String lastName;
	private String jobDescription;
	private String address;
	
	

	public Employee() {
		// TODO Auto-generated constructor stub
	}



	public Employee(String firstName, String lastName, String jobDescription,String address) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.jobDescription = jobDescription;
		this.address = address;
	}

}
