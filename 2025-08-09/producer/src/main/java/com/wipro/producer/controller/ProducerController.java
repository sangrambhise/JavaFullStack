package com.wipro.producer.controller;
import org.springframework.context.annotation.*;
import com.wipro.producer.service.SubjectProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produce")
public class ProducerController {

    @Autowired
    private SubjectProducer subjectProducer;

    @GetMapping("/{msg}")
    public String send(@PathVariable String msg) {
        subjectProducer.sendMessage(msg);
        return "Message sent: " + msg;
    }
}
