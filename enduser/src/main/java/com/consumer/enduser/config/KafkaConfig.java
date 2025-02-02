package com.consumer.enduser.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.scheduling.annotation.Scheduled;

@Configuration
public class KafkaConfig {
    @KafkaListener(topics = "location", groupId = "group-1")
    public void getLocations(String message) throws InterruptedException {
        System.out.println("Getting locations "+message);
    }
}
