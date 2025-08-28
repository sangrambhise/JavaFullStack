package com.wipro.payment.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

 
import com.wipro.payment.entity.Payment;
import com.wipro.payment.service.*;

@RestController
@RequestMapping("/payment")
public class PaymentController {
	
	@Autowired
	PaymentService paymentService;
	
	@GetMapping
	List<Payment> findAll()
	{
		return paymentService.findAll();
	}
	@GetMapping("/{id}")
	Payment findById(@PathVariable int id)
	{
		return paymentService.findById(id);
	}
	@DeleteMapping("/{id}")
	void deleteById(@PathVariable int id)
	{
		paymentService.deleteById(id);
	}
	 
	@PutMapping
	void update(@RequestBody Payment payment)
	{
		paymentService.save(payment);
		
	}

}
