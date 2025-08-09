package com.wipro.producer.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import com.wipro.producer.model.Subject;

@Service
public class SubjectProducer {

    private static final String TOPIC = "learn-subject";

    @Autowired
    private KafkaTemplate<String, Subject> kafkaTemplate;

    public void sendSubject(Subject subject) {
        kafkaTemplate.send(TOPIC, subject);
    }
}
