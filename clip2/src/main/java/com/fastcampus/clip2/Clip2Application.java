package com.fastcampus.clip2;

import org.apache.kafka.common.Metric;
import org.apache.kafka.common.MetricName;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.MessageListenerContainer;

import java.util.Map;

@SpringBootApplication
public class Clip2Application {

    public static void main(String[] args) {
        SpringApplication.run(Clip2Application.class, args);
    }

    @Bean
    public ApplicationRunner runner(KafkaTemplate<String, String> kafkaTemplate,
                                    KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry) {
        return args -> {
            Map<MetricName, ? extends Metric> producerMetrics = kafkaTemplate.metrics();

            MessageListenerContainer container = kafkaListenerEndpointRegistry.getListenerContainer("clip2-listener");
            Map<String, Map<MetricName, ? extends Metric>> consumerMetrics = container.metrics();
        };
    }
}
