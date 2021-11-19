package com.fastcampus.clip4.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class ClipConsumer {

    @KafkaListener(id = "clip4-to-listener", topics = "clip4-to")
    public void listen(String message) {
        System.out.println("Listener. message=" + message);
    }
}
