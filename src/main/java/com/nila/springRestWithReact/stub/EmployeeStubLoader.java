package com.nila.springRestWithReact.stub;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nila.springRestWithReact.model.Employee;
import com.nila.springRestWithReact.repository.EmployeeRepository;

@Component
public class EmployeeStubLoader implements CommandLineRunner {

	private final EmployeeRepository employeeRepository;
	
	@Autowired
	public EmployeeStubLoader(EmployeeRepository employeeRepository) {
		this.employeeRepository= employeeRepository;
	}

	@Override
	public void run(String... args) throws Exception {
		Arrays.asList("John", "Doe")
			.forEach(name ->
		this.employeeRepository.save(new Employee(name,"","Developer","Cognizant,Siruseri,603103,Chennai")));

	}

}
