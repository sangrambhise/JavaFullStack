package com.wipro.payment.service;

import java.util.List;

 
import com.wipro.payment.entity.Payment;

 

public interface PaymentService {
	List<Payment> findAll();
	Payment findById(int id);
	Payment save(Payment payment);
	void deleteById(int id);
}
