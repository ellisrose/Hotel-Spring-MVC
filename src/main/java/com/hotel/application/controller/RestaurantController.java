package com.hotel.application.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("restaurant")
public class RestaurantController {
	
	@GetMapping("/restaurant")
	public String landing() {
		return "restaurant";
	}
	
	@GetMapping("/mealtype")
	public String mealType() {
		return "selectmealtypes";
	}
	
	@GetMapping("/validation")
	public String validCard() {
		return "mealcardvalid";
	}
//	
//	@GetMapping("/book")
//	public String book() {
//		return "booknow";
//	}
	
	@GetMapping("/restreserve")
	public String restreserve() {
		return "restreserve";
	}
	
	@GetMapping("/mealType")
	public String meal() {
		return "selectmealtype";
	}
	
	@GetMapping("/confirmation")
	public String confirm() {
		return "restconfirmation";
	}
	
	
	
	

}
