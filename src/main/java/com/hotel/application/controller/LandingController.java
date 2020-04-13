package com.hotel.application.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.application.entity.Order;
import com.hotel.application.entity.Reservation;
import com.hotel.application.entity.User;
import com.hotel.application.service.OrderService;
import com.hotel.application.service.ReservationService;



@Controller
public class LandingController {
	
	@Autowired
	private ReservationService reservationService;
	
	@Autowired
	private OrderService orderService;
	
	@GetMapping("/")
	public String landing(Model model)  {
		return "landing";
	}
	
	//add request mapping for leaders
	@GetMapping("/leaders")
	public String showLeaders() {
		return "leaders";
	}
	
	@GetMapping("/systems")
	public String system() {
		return "systems";
	}
	
	@GetMapping("/admin")
	public String admin() {
		return "admin";
	}
	
	@GetMapping("/contact")
	public String contact() {
		return "contact";
	}
	
	@GetMapping("/about")
	public String about() {
		return "about";
	}
	
//	@GetMapping("/rooms")
//	public String rooms() {
//		return "room-types";
//	}
	
	@GetMapping("/display-room-types")
	public String roomsTypes() {
		return "display-room-types";
	}
	
	@GetMapping("/confirm")
	public String r() {
		return "reserveconfirmation";
	}
	
	@PostMapping("/search")
	public String search(@RequestParam("confirm") long confirmId, Model theModel) {
		Reservation theReservations = 
				reservationService.searchReservation(confirmId);
		
		//System.out.println("\n\n====================Order number: " + theReservations.getOrder());
		
		if(theReservations.getOrder()==null) {
			theModel.addAttribute("reservation", theReservations);
			theModel.addAttribute("null", "order");
		}else {
			Order theOrder = orderService.getOrder(theReservations.getOrder().getOrderId());
			theModel.addAttribute("reservation", theReservations);
			theModel.addAttribute("order", theOrder);	
		}	
		
		

		return "reservationdetails";
	}

}
