package com.contacto.controller.view;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthVuewController {

	@GetMapping("/login")
	public String login() {
		return "login";
	}
}
