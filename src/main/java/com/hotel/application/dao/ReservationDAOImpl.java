package com.hotel.application.dao;
import java.util.List;

import javax.persistence.criteria.From;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotel.application.entity.Reservation;


@Repository
public class ReservationDAOImpl implements ReservationDAO {
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveReservation(Reservation theReservation) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theReservation);
	}

	@Override
	public void savePriceReservation(long theId, double thePrice, String theRoomType ) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery =
				currentSession.createQuery("Update reservation set price = :price"+
						" where reservation_id = :id");
		theQuery.setParameter("id", theId);
		theQuery.setParameter("price", thePrice);
//		theQuery.setParameter("room_type", theRoomType);
		
		theQuery.executeUpdate();
	}
	
	

	public void updateReservation(long id) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(id);	
	}
	
	public Reservation getReservation(long theId) {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//now retrieve/read from database using the primary key
		Reservation theReservation = currentSession.get(Reservation.class, theId);		
		return theReservation;
		
	}

	@Override
	public Reservation searchReservation(long confirmId) {
		//get the currunt hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = null;
		
		if(confirmId != 0) {
			theQuery =currentSession.createQuery
					("from Reservation where id=:theId", Reservation.class);
			theQuery.setParameter("theId", confirmId);
		}else {
			System.out.println("OPSS, I did it again");
		}
		// execute query and get result list
		Reservation reservation = (Reservation) theQuery.getSingleResult();
		
		return reservation;
	}

}
