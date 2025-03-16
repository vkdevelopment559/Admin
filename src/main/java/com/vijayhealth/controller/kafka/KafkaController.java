package com.vijayhealth.controller.kafka;

import com.vijayhealth.service.kafka.producer.KafkaProducerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class KafkaController {

    private final KafkaProducerService producerService;

    public KafkaController(KafkaProducerService producerService) {
        this.producerService = producerService;
    }

    @GetMapping("/publish")
    public String publishMessage(@RequestParam("message") String message) {
        producerService.sendMessage(message);
        return "Message sent: " + message;
    }


}

