package com.simplilearn.service;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.simplilearn.exception.EmployeeNotFoundException;
import com.simplilearn.model.Employee;

@Service
public class EmployeeService {

	public List<Employee> retrieveEmployees() throws EmployeeNotFoundException {
		
		if(true) {
			throw new EmployeeNotFoundException();
		}
		return null;
	}
}
