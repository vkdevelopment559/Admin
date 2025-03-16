package com.vijayhealth.service.kafka.producer;

import com.vijayhealth.entity.book.BookEntity;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaProducerServiceImpl implements KafkaProducerService {

    private static final String TOPIC = "my-topic";
    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerServiceImpl(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void sendMessage(String message) {
        kafkaTemplate.send(TOPIC, message);
        System.out.println("Produced message: " + message);
    }


    public void sendBookMessage(BookEntity book) {
        CompletableFuture<SendResult<String, String>> send= kafkaTemplate.send(TOPIC, book.toString());
         send.whenComplete((result, ex) -> System.out.println("Produced message: " + result.getRecordMetadata().offset()));

    }
}

