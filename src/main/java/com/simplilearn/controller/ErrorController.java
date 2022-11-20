package com.simplilearn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.exception.EmployeeNotFoundException;
import com.simplilearn.model.Employee;
import com.simplilearn.service.EmployeeService;

@RestController
public class ErrorController {

	@Autowired
	EmployeeService employeeService;

	@GetMapping("/calculate1")
	public int calculate() {
		int a = 5;
		int b = 0;
		int c = a / b;

		return c;
	}

	@GetMapping("/employees")
	public String retriveEmployees() throws EmployeeNotFoundException {
		List<Employee> employees = employeeService.retrieveEmployees();
		return "";
	}
}
