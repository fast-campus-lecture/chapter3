package com.fastcampus.clip4;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;

import java.util.Date;

@SpringBootApplication
public class Clip4Application {

    public static void main(String[] args) {
        SpringApplication.run(Clip4Application.class, args);
    }

    @Bean
    public ApplicationRunner runner(KafkaTemplate<String, String> kafkaTemplate) {
        return args -> {
            while (true) {
                kafkaTemplate.send("clip4", String.valueOf(new Date().getTime()));
                Thread.sleep(1_000);
            }
        };
    }
}
