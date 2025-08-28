package com.wipro.payment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.wipro.payment.entity.Payment;
import com.wipro.payment.repo.PaymentRepo;
import com.wipro.payment.util.AppConstant;

@Service
public class OTOPConsumer {
	
	@Autowired
	PaymentRepo paymentRepo;
	@Autowired
	KafkaTemplate kafkaTemplate;

	@KafkaListener(topics=AppConstant.INCOMING_TOPIC_NAME,groupId="payment_service")
	public void receiveUpiPayment(Payment payment) {
		System.out.println("---Message Received ---"+payment);
		payment.setPaymentStatus(1);
		paymentRepo.save(payment);
		kafkaTemplate.send(AppConstant.OUTGOING_TOPIC_NAME,payment);
		
	}
}
