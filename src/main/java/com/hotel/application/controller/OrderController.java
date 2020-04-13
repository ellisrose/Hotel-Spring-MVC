package com.hotel.application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hotel.application.entity.Order;
import com.hotel.application.entity.Reservation;
import com.hotel.application.service.OrderService;
import com.hotel.application.service.ReservationService;



@Controller
@RequestMapping("/order")
public class OrderController {
	public long id;
	@Autowired
	private OrderService orderService;
	
	@Autowired
	private ReservationService reservationService;
	
	@GetMapping("/new")
	public String newOrderForm(Model theModel) {
		//create model attribute to bind form data
//		orderForm theOrderForm = new orderForm();
		
		Order theOrder = new Order();
		
		theModel.addAttribute("order", theOrder);
		return "selectmealtype";
	}
	
	@PostMapping("/save")
	public String saveOrder(@ModelAttribute("order") Order theOrder,
			@RequestParam("reservationId") long reservationId, 
			Model theModel){
		
		//checking if reservation ID exists...
//		TODO: validation to check whether if id exists or not 
		Reservation reservation = reservationService.getReservation(reservationId);
		//Calculating cost of food
		double totalPrice = (theOrder.getNumBreakfast()*10) 
				+ (theOrder.getNumLunch()*15) 
				+ (theOrder.getNumDinner()*20);
		//setting the price in order class 
		theOrder.setPrice(totalPrice);
		//saving order to database
		orderService.saveOrder(theOrder);
		//setting order id number to reservation
		reservation.setOrder(theOrder);
		//saving orderId number in reservation database as a foreign key 
		reservationService.saveReservation(reservation);

		return "mealcardvalid"; 
	}
	
	@GetMapping("/show")
	public String showFormForUpdate(Model theModel) {
				
		//get the order from the database
		Order theOrder = orderService.getOrder(id);
		
		//set customer from the database
		theModel.addAttribute("order", theOrder);
		
		//send over to our form
		return "restconfirmation";
	}
	
	Order calcOrderPrice(Order o) {
		o.setPrice(o.getPrice()+(10*o.getNumBreakfast()));
		o.setPrice(o.getPrice()+(15*o.getNumLunch()));
		o.setPrice(o.getPrice()+(25*o.getNumDinner()));
		return o;
	}
}
