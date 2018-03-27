package com.github.alexivchenko.chat;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

/**
 * @author Alex Ivchenko
 */
@Slf4j
@Controller
public class ChatController {
    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public Message chat(@Payload Message message) {
        log.info(message.toString());
        return message;
    }
}
