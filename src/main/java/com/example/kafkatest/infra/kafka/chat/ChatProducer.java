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
    private static final String TOPIC = "chat-topic";

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;

    public void sendMessage(ChatMessage chatMessage) {
//        System.out.println(chatMessage);
        try {
            String stringMessage = objectMapper.writeValueAsString(chatMessage);
//            System.out.println("string: " + stringMessage);
            kafkaTemplate.send(TOPIC, stringMessage);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("메시지 직렬화 실패!", e);
        }
    }
}
