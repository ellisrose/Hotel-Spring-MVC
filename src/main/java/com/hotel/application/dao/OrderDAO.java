package com.hotel.application.dao;

import java.util.List;

import com.hotel.application.entity.Order;


public interface OrderDAO {
	public List<Order> getOrder();

	public void saveOrder(Order theOrder);

	public Order getOrder(long theId);
}
