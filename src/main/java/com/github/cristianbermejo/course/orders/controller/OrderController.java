package com.github.cristianbermejo.course.orders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.cristianbermejo.course.orders.model.Order;
import com.github.cristianbermejo.course.orders.service.OrderService;

@RestController
@CrossOrigin("*")
public class OrderController {

	@Autowired
	OrderService service;
	
	@GetMapping(value = "orders", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Order> getAll() {
		return service.getAll();
	}
	
	@PostMapping(value = "order", consumes = MediaType.APPLICATION_JSON_VALUE)
	public void createOrder(@RequestBody Order order) {
		service.createOrder(order);
	}
}
