package com.example.kafkatest.domain.chat.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;

@ToString
@Getter
public class ChatMessage implements Serializable {
    private String sender;
    private String content;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private Instant timestamp;
}
