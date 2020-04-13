package com.hotel.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	@GetMapping("loginPage")
	public String showLoginPage() {
		return "login";
	}
	
	// add a request mapping for access-denied
	@GetMapping("/access-denied")
	public String showAccessDenied() {
		return "access-denied";
	}
	
	

}
