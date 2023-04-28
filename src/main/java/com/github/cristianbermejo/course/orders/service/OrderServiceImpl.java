package com.github.cristianbermejo.course.orders.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.github.cristianbermejo.course.orders.dao.OrderDao;
import com.github.cristianbermejo.course.orders.model.Order;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderDao dao;
	
	@Autowired
	RestTemplate template;
	
	@Value("${products.baseUrl}")
	String baseUrl;

	@Override
	public List<Order> getAll() {
		return dao.findAll();
	}

	@Override
	public void createOrder(Order order) {
		order.setDate(new Date());
		order.setTotal(order.getQuantity() * getProductPrice(order.getProductCode()));
		
		dao.save(order);
		updateStock(order.getProductCode(), order.getQuantity());
	}
	
	private double getProductPrice(int productCode) {
		return Double.parseDouble(template.getForObject(baseUrl + "/product{productCode}/price", String.class, productCode));
	}
	
	private void updateStock(int productCode, int unitsToSubstract) {
		template.put(baseUrl + "/product/{code}/stock?substractUnits={units}", productCode, unitsToSubstract);
	}

}
