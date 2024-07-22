package com.example.kafkatest.infra.kafka.chat;

import com.example.kafkatest.domain.chat.dto.ChatMessage;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
@AllArgsConstructor
public class ChatConsumer {
    private final SimpMessagingTemplate template;   // 특정 broker 로 메시지 전달
    private final ObjectMapper objectMapper;

    @KafkaListener(topics = "chat-topic", groupId = "chat-group")
    public void listen(String stringMessage) {
        System.out.println("Received Message in group chat-group: " + stringMessage);
        try {
            // 메시지 처리 로직 (예: WebSocket을 통해 클라이언트에게 전송)
            ChatMessage chatMessage = objectMapper.readValue(stringMessage, ChatMessage.class);
            template.convertAndSend("/topic/messages", chatMessage);
        } catch (IOException e) {
            throw new RuntimeException("메시지 역직렬화 실패!, e");
        }
    }
}
