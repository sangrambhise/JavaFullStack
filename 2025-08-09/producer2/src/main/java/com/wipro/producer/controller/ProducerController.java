package com.wipro.producer.controller;
import org.springframework.context.annotation.*;
import com.wipro.producer.service.SubjectProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.wipro.producer.model.Subject;

@RestController
@RequestMapping("/produce")
public class ProducerController {

    @Autowired
    private SubjectProducer subjectProducer;

    @PostMapping
    public String sendSubject(@RequestBody Subject subject) {
        subjectProducer.sendSubject(subject);
        return "Subject sent: " + subject.toString();
    }
}
