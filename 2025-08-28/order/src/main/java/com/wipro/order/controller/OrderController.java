package com.wipro.order.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wipro.order.dto.Payment;

import com.wipro.order.entity.OrderEntity;
import com.wipro.order.service.*;

@RestController
@RequestMapping("/order")
public class OrderController {

	@Autowired
	OrderService orderService;

	@GetMapping
	List<OrderEntity> findAll() {
		return orderService.findAll();
	}

	@GetMapping("/{id}")
	OrderEntity findById(@PathVariable int id) {
		return orderService.findById(id);
	}

	@DeleteMapping("/{id}")
	void deleteById(@PathVariable int id) {
		orderService.deleteById(id);
	}

	@PostMapping
	OrderEntity save(@RequestBody OrderEntity order, @RequestHeader("Authorization") String authToken,
			@RequestAttribute("userId") String userId)

	{
		System.out.println("userId=" + userId);
		System.out.println("authHeader=" + authToken);
		System.out.println(order);
		order.setUserId(Integer.parseInt(userId));
		OrderEntity orderReturn = orderService.save(order, authToken);
		return orderReturn;
	}

	@PutMapping
	void update(@RequestBody OrderEntity order) {
		orderService.save(order, "");

	}

	@PostMapping("/pay")
	Payment pay(@RequestBody Payment pay) {
		
		System.out.println(pay);
		orderService.pay(pay);
		return pay;
	}
}
