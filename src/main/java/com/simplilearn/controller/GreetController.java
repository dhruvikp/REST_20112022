package com.simplilearn.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.model.Greet;

// @RestController = @Controller + @ResponseBody
@RestController
public class GreetController {

	// @GetMapping("/greet")
	@RequestMapping(value = "/greet", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public Greet greet() {
		Greet greet = new Greet();
		greet.setUsername("Dhruvik");
		greet.setMessage("Welcome to simplilearn!");
		return greet;
	}
}
