package com.github.cristianbermejo.course.orders.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.github.cristianbermejo.course.orders.model.Order;

public interface OrderDao extends JpaRepository<Order, Integer> {

}
