package com.wipro.order.service;

import java.util.List;

import com.wipro.order.dto.Payment;
import com.wipro.order.entity.OrderEntity;

 

public interface OrderService {
	List<OrderEntity> findAll();
	OrderEntity findById(int id);
	OrderEntity save(OrderEntity orderEntity,String token);
	void deleteById(int id);
	void pay(Payment payment);
}
