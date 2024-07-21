package com.example.kafkatest.infra.kafka.chat;

import com.example.kafkatest.domain.chat.dto.ChatMessage;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@Slf4j
@AllArgsConstructor
public class ChatConsumer {

    @KafkaListener(topics = "chat-topic", groupId = "chat-group")
    public void listen(ChatMessage chatMessage) throws IOException {

        // 메시지 처리 로직 (예: WebSocket을 통해 클라이언트에게 전송)
        System.out.println("Received Message in group chat-group: " + chatMessage.toString());
    }
}
