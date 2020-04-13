package com.hotel.application.service;
import java.util.List;

import com.hotel.application.entity.Order;



public interface OrderService {
		public List<Order> getOrder();

		public void saveOrder(Order theOrder);

		public Order getOrder(long theId);
}
