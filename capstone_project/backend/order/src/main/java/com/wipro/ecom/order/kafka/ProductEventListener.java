package com.wipro.ecom.order.kafka;


import com.wipro.ecom.events.ProductEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ProductEventListener {

    @KafkaListener(topics = "product-topic", groupId = "order-service-group")
    public void consumeProductEvent(ProductEvent event) {
        System.out.println(" Order Service received product event: " + event);
    }
}
