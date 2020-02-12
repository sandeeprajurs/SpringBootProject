package com.todo.webapp.restfulwebservices.basic.auth;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins="http://localhost:4200")
public class AuthenticationController {
	
	@GetMapping("/basicauth")
	public AuthenticationBean authorise() {
		return new AuthenticationBean("You are authorised");
	}
}
