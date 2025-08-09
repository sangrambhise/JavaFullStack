package com.wipro.consumer.consumerone;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class SubjectListener {

    @KafkaListener(topics = "learn-subject", groupId = "subject-group")
    public void listen(String message) {
        System.out.println("Received in Spring Consumer App: " + message);
    }
}
