package com.wipro.paymentms.repo;
import com.wipro.paymentms.entity.Payment;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepo extends JpaRepository<Payment, Integer> {
	List<Payment> findByOrderId(int orderId);

}

