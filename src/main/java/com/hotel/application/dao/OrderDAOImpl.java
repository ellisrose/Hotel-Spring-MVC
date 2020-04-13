
package com.hotel.application.dao;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hotel.application.entity.Order;



@Repository
public class OrderDAOImpl implements OrderDAO {
	
	@Autowired
	SessionFactory sessionFactory;
	
	@Override
	public List<Order> getOrder() {
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query
		Query<Order> theQuery= 
				currentSession.createQuery("from Order order by order_id", Order.class);
		
		// execute query ad get result list
		List<Order> orders = theQuery.getResultList();
		
		//return the results 
		return orders;
	}


	@Override
	public void saveOrder(Order theOrder) {
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//save/update the customer ...
		currentSession.saveOrUpdate(theOrder);
		
	}


	@Override
	public Order getOrder(long theId) {
		
		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		
		//now retrieve/read from database using the primary key
		Order theOrder = currentSession.get(Order.class, theId);
		
		return theOrder;
		
	}

}
