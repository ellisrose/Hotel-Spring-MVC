package com.hotel.application.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotel.application.entity.Room;
import com.hotel.application.entity.RoomType;


@Repository
public class RoomDAOImpl implements RoomDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(Room room) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(room);
	}

	@Override
	public void delete(Room room) {
		Session session = sessionFactory.getCurrentSession();	
		session.delete(room);

	}

	@Override
	public Room get(int roomNumber) {

		Session session = sessionFactory.getCurrentSession();
		// delete object with primary key
		Query theQuery = session.createQuery("from Room where roomNumber=:roomNumber");
		theQuery.setParameter("roomNumber", roomNumber);
		Room room = (Room) theQuery.getSingleResult();
		return room;
	}

	@Override
	public List<Room> listAll() {
		@SuppressWarnings("unchecked")
		TypedQuery<Room> query = sessionFactory.getCurrentSession().createQuery("from Room");
		return query.getResultList();
	}

	@Override
	public List<Room> listByType(String roomType) {

		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Room> criteriaQuery = criteriaBuilder.createQuery(Room.class);
		Root<Room> root = criteriaQuery.from(Room.class);
		criteriaQuery.select(root);
		criteriaQuery.where(criteriaBuilder.equal(root.get("typeName"), roomType));

		Query query = session.createQuery(criteriaQuery);

		List<Room> results = query.getResultList();
		return results;
	}

	@Override
	public List<RoomType> listOfType() {
		Session session = sessionFactory.getCurrentSession();

		TypedQuery<RoomType> q = session.createQuery(
				"SELECT new com.hotel.application.entity.RoomType(r.typeName,r.price) FROM Room r GROUP BY r.typeName, r.price",
				RoomType.class);

		List<RoomType> roomTypes = q.getResultList();
		return roomTypes;

	}

}
