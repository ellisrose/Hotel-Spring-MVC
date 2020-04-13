package com.hotel.application.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotel.application.dao.OrderDAO;
import com.hotel.application.entity.Order;



@Service
public class OrderServiceImpl implements OrderService{
	//need to inject customer deo
			@Autowired
			private OrderDAO orderDAO;
			
			
			@Override
			@Transactional
			public List<Order> getOrder() {
				return orderDAO.getOrder();
			}


			@Override
			@Transactional
			public void saveOrder(Order theOrder) {
				orderDAO.saveOrder(theOrder);
				
			}


			@Override
			@Transactional
			public Order getOrder(long theId) {
				return orderDAO.getOrder(theId);

			}

}
