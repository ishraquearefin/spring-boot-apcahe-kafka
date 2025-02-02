package com.producer.deliverybody.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @Autowired
    public KafkaTemplate<String, String> kafkaTemplate;

    public boolean sendMessage(String message) {
        kafkaTemplate.send("location", message);
        return true;
    }

}
