package com.wipro.ecom.product.kafka;

import com.wipro.ecom.events.OrderEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderEventListener {

    @KafkaListener(topics = "order-topic", groupId = "product-service-group")
    public void consumeOrderEvent(OrderEvent event) {
        System.out.println(" Product Service received order event: " + event);
    }
}
