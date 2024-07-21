package com.example.kafkatest.domain.chat.controller;

import com.example.kafkatest.domain.chat.dto.ChatMessage;
import com.example.kafkatest.domain.chat.service.ChatService;
import com.example.kafkatest.infra.kafka.chat.ChatProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@AllArgsConstructor
public class ChatController {

    private final ChatService chatService;
//    private final ChatProducer chatProducer;

//    @PostMapping("/send")
//    public void sendMessage(@RequestBody String message) {
//        chatProducer.sendMessage("chat-topic", message);
//    }
    @MessageMapping("/sendMessage")
//    @SendTo("/topic/messages")
    public ChatMessage sendMessage(@Payload ChatMessage chatMessage) {
        return chatService.sendChatMessage(chatMessage);
    }
}
