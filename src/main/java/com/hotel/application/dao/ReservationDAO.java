package com.hotel.application.dao;
import java.util.List;

import com.hotel.application.entity.Reservation;



public interface ReservationDAO {
	public void saveReservation(Reservation theReservation);

	public void savePriceReservation(long theId, double price, String roomType);

	public void updateReservation(long id);
	
	public Reservation getReservation(long theId);

	public Reservation searchReservation(long confirmId);

}
