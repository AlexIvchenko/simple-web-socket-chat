package com.github.alexivchenko.chat;

import com.github.alexivchenko.chat.auth.JwtAuthenticationToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.security.Principal;

/**
 * @author Alex Ivchenko
 */
@Slf4j
@Controller
public class ChatController {
    @MessageMapping("/chat/channels/{channel}")
    @SendTo("/topic/channels/{channel}/messages")
    public OutputMessage channel(@Payload InputMessage input, Principal principal) {
        log.info("chat, message: {}", input);
        JwtAuthenticationToken auth = (JwtAuthenticationToken) principal;
        log.info(input.toString());
        OutputMessage output = new OutputMessage();
        output.setSender(auth.getUsername());
        output.setText(input.getText());
        return output;
    }

    @MessageMapping("/chat/direct/{username}")
    @SendTo("/topic/direct/{username}/messages")
    public OutputMessage dierect(@Payload InputMessage input, Principal principal) {
        log.info("chat, message: {}", input);
        JwtAuthenticationToken auth = (JwtAuthenticationToken) principal;
        log.info(input.toString());
        OutputMessage output = new OutputMessage();
        output.setSender(auth.getUsername());
        output.setText(input.getText());
        return output;
    }
}
