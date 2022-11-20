package com.simplilearn.config;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.simplilearn.exception.EmployeeNotFoundException;

@RestControllerAdvice
public class ErrorConfig {
	
	@ExceptionHandler(value = Exception.class)
	public String arithmatic() {
		return "Exception occurred! Please contact administrator";
	}

	@ExceptionHandler(value = EmployeeNotFoundException.class)
	public String employeeNotfound() {
		return "Employees not available in DB!";
	}
}
