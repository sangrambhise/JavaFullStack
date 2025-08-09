package com.wipro.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class SubjectProducer {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private static final String TOPIC = "learn-subject";

    public void sendMessage(String message) {
        kafkaTemplate.send(TOPIC, message);
    }
}
