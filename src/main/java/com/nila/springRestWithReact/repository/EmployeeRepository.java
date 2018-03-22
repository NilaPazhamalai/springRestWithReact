package com.nila.springRestWithReact.repository;

import org.springframework.data.repository.CrudRepository;

import com.nila.springRestWithReact.model.Employee;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {

}
