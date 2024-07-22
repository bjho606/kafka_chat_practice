package com.example.kafkatest.domain.chat.controller;

import com.example.kafkatest.domain.chat.dto.ChatMessage;
import com.example.kafkatest.domain.chat.service.ChatService;
import com.example.kafkatest.infra.kafka.chat.ChatProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class ChatController {

    private final ChatService chatService;

    // Client가 SEND할 수 있는 경로
    // WebSocketConfig에서 설정한 applicationDestinationPrefixes와 @MessageMapping 경로가 병합됨
    // "/pub/chat/sendMessage"
    @MessageMapping("/chat/sendMessage")
    @SendTo("/topic/messages")
    public ChatMessage sendMessage(ChatMessage chatMessage) {
//        System.out.println("input message:" + chatMessage.toString());

        return chatService.sendChatMessage(chatMessage);
    }
}
