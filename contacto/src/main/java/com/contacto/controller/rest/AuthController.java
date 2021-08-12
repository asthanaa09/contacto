package com.contacto.controller.rest;

import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.contacto.models.pojo.LoginRequest;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

	
	@PostMapping("/login")
	public String login(@RequestBody LoginRequest loginRequest) {
		System.out.println("Username " + loginRequest.getUsername() + ", Password "+ loginRequest.getPassword());
		return "SUCCESS";
	}
}
