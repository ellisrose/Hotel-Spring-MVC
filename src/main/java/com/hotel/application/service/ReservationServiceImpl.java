package com.hotel.application.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.application.dao.ReservationDAO;
import com.hotel.application.entity.Reservation;




@Service
public class ReservationServiceImpl implements ReservationService {
	
	@Autowired
	private ReservationDAO reservationDAO;

	@Override
	@Transactional
	public void saveReservation(Reservation theReservation) {
		reservationDAO.saveReservation(theReservation);
	}

	@Override
	@Transactional
	public void savePriceReservation(long theId, double price, String roomType) {
		reservationDAO.savePriceReservation(theId, price, roomType);
		
	}

	@Override
	@Transactional
	public Reservation getReservation(long id) {
		return reservationDAO.getReservation(id);
		
	}

	@Override
	@Transactional
	public Reservation searchReservation(long confirmId) {
		return reservationDAO.searchReservation(confirmId);
	}
	

}
