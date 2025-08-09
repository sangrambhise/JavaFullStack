package com.wipro.consumer.consumerone;

import com.wipro.consumer.model.LearnSubject;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class SubjectListener {

	 @KafkaListener(topics = "learn-subject", groupId = "subject-group", containerFactory = "subjectKafkaListenerFactory")
	 public void listen(LearnSubject subject) {
		    System.out.println("Received Subject: " + subject);
		}
}
