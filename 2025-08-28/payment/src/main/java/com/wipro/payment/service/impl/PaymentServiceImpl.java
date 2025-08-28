package com.wipro.payment.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wipro.payment.entity.Payment;
import com.wipro.payment.repo.PaymentRepo;
import com.wipro.payment.service.PaymentService;
 
 

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	PaymentRepo paymentRepo;
	
	 
	
 
 
	public List<Payment> findAll() {
		// TODO Auto-generated method stub
		return paymentRepo.findAll();
	}

 
	public Payment findById(int id) {
		// TODO Auto-generated method stub
		Optional<Payment> paymentOpt= paymentRepo.findById(id);
		if(paymentOpt.isPresent())
		{
			return paymentOpt.get();
		}
		return null;
	}

	public Payment save(Payment payment) {
		return payment;
	  
	 
	 
	}

 
	public void deleteById(int id) {
		// TODO Auto-generated method stub
		paymentRepo.deleteById(id);
	}


}
