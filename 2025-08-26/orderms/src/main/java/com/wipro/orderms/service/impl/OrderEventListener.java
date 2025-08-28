package com.wipro.orderms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.wipro.common.dto.PaymentCompletedEvent;
import com.wipro.orderms.repo.OrderRepo;

@Component
public class OrderEventListener {
    @Autowired private OrderRepo orderRepo;

    @KafkaListener(topics = "payment-events", groupId = "orderms-group")
    public void onPaymentCompleted(PaymentCompletedEvent event) {
        orderRepo.findById(event.getOrderId()).ifPresent(order -> {
            order.setOrderStatus(event.isPaymentStatus() ? "P" : "F");
            orderRepo.save(order);
        });
    }
}
