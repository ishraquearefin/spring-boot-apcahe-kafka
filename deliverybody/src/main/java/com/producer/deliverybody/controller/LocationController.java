package com.producer.deliverybody.controller;


import com.producer.deliverybody.service.KafkaService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/location")
//@RequiredArgsConstructor
public class LocationController {

    @Autowired
    private KafkaService kafkaService;

        @PostMapping("/send")
        public ResponseEntity<?> sendLocation() {
            for(int i=0;i<1000000;i++) {
                kafkaService.sendMessage("Location sent" + " " + i);
            }
            return new ResponseEntity<>(Map.of("message", "Location sent"), HttpStatus.OK);
        }
}
