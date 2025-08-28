package com.wipro.payment.entity;

 

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="payment_details")
@Data
public class Payment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	int id;
	
	@Column(name="order_id")
	String orderId;
	
	 	 
	@Column(name="payment_price")
	double totalOrderPrice;
	
	@Column(name="payment_status")
	int paymentStatus;
	
	@Column(name="payment_mode")
	String modeOfPayment; 
	
	@Column(name="account_number")
	String accountNumber;
	
	@Column(name="cvv")
	int cvv;
}
