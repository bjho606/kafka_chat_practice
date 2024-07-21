package com.example.kafkatest.domain.chat.service;

import com.example.kafkatest.domain.chat.dto.ChatMessage;
import com.example.kafkatest.infra.kafka.chat.ChatProducer;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ChatService {

    private final ChatProducer chatProducer;

    public ChatMessage sendChatMessage(ChatMessage chatMessage) {
        chatProducer.sendMessage(chatMessage);
        return chatMessage;
    }

}
