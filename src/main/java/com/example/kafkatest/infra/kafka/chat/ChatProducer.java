package com.example.kafkatest.infra.kafka.chat;

import com.example.kafkatest.domain.chat.dto.ChatMessage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@AllArgsConstructor
public class ChatProducer {
    private static final String TOPIC = "chat-messages";

    private final KafkaTemplate<String, Object> kafkaTemplate;
//    private final ObjectMapper objectMapper;

    public void sendMessage(ChatMessage message) {
//        kafkaTemplate.send("chat-topic", objectMapper.writeValueAsString(message));
        kafkaTemplate.send(TOPIC, message);
    }
}
