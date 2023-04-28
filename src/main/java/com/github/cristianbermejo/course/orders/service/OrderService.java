package com.github.cristianbermejo.course.orders.service;

import java.util.List;

import com.github.cristianbermejo.course.orders.model.Order;

public interface OrderService {
	List<Order> getAll();
	void createOrder(Order order);
}
