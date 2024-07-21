package com.example.kafkatest.domain.chat.dto;

import lombok.ToString;

import java.time.LocalDateTime;

@ToString
public class ChatMessage {
    private String sender;
    private String content;
    private LocalDateTime timestamp;
}
