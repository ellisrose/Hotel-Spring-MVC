package com.hotel.application.controller;

import javax.persistence.Id;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.application.entity.Reservation;
import com.hotel.application.service.ReservationService;



@Controller
@RequestMapping("/reservation")
public class ReservationController {
	long id =0;
	
	@Autowired
	private ReservationService reservationService;
	
	@GetMapping("/book")
	public String booking(Model theModel) {
		Reservation theReservation = new Reservation();
		theModel.addAttribute("reservation", theReservation);
		return "booknow";	
	}
	
	@PostMapping("/new")
	public String reservationForm(@ModelAttribute("reservation") Reservation theReservation, Model theModel) {
		
		reservationService.saveReservation(theReservation);
		System.out.println("ID = " + theReservation.getId());
		//Save id to update the price in next page
		id = theReservation.getId(); 
		
		theModel.addAttribute("reservation" ,theReservation);
		//System.out.println(theReservation.toString());
		
		return "room-types";
		
	}
	
	@PostMapping("room-type-standard")
	public String room(@RequestParam("type") String roomType, Model theModel) {
		
		Reservation res = reservationService.getReservation(id);

		if (roomType.equals("Standard")) {
			res.setPrice(50 * res.getNumRooms());
			res.setRoomType(roomType);
			reservationService.saveReservation(res);
		} else if(roomType.equals("Presidential")){
			res.setPrice(200 * res.getNumRooms());
			res.setRoomType(roomType);
			reservationService.saveReservation(res);
		}else if(roomType.equals("Delux")){
			res.setPrice(100 * res.getNumRooms());
			res.setRoomType(roomType);
			reservationService.saveReservation(res);
		}
		
		theModel.addAttribute("reservation",res);
		
		
//		reservationService.savePriceReservation(id, 50, roomType);
		return "reservation-card-validation";	
	}
	

}
