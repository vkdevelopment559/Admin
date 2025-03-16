package com.vijayhealth.service.kafka.consumer;


import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerServiceImpl implements KafkaConsumerService {

    @KafkaListener(topics = "my-topic", groupId = "my-group")
    @Override
    public void consume(String message) {
        System.out.println("Consumed message: " + message.toString());
    }
}

