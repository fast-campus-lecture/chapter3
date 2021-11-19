package com.fastcampus.clip2.controller;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class Clip2Controller {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public Clip2Controller(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @GetMapping("/produce")
    public String produce() throws InterruptedException {
        while (true) {
            kafkaTemplate.send("clip2", String.valueOf(new Date().getTime()));
            Thread.sleep(100L);
        }
    }
}
