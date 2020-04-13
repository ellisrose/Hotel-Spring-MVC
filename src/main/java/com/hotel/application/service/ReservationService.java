package com.hotel.application.service;

import java.util.List;

import com.hotel.application.entity.Reservation;



public interface ReservationService {
	
	public void saveReservation(Reservation theReservation);
	
	public void savePriceReservation(long theId, double price, String roomType );

	public Reservation getReservation(long id);

	public Reservation searchReservation(long confirmId);

}
