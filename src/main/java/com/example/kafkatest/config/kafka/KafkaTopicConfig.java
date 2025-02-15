package com.example.kafkatest.config.kafka;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.TopicBuilder;
import org.apache.kafka.clients.admin.NewTopic;

@Configuration
public class KafkaTopicConfig {
    @Bean
    public NewTopic chatTopic() {
        return TopicBuilder.name("chat-topic")
                .partitions(1)
                .replicas(1)
                .build();
    }
}
