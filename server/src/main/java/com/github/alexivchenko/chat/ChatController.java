package com.github.alexivchenko.chat;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessageHeaderAccessor;
import org.springframework.stereotype.Controller;

/**
 * @author Alex Ivchenko
 */
@Slf4j
@Controller
public class ChatController {
    @MessageMapping("/chat")
    @SendTo("/topic/messages")
    public OutputMessage chat(@Payload InputMessage input, SimpMessageHeaderAccessor headerAccessor) {
        log.info(input.toString());
        OutputMessage output = new OutputMessage();
        output.setText(input.getText());
        String username = (String) headerAccessor.getSessionAttributes().get("username");
        output.setSender(username);
        output.setType(OutputMessage.Type.CHAT);
        return output;
    }

    @MessageMapping("/chat.users.add")
    @SendTo("/topic/messages")
    public OutputMessage addUser(@Payload User user, SimpMessageHeaderAccessor headerAccessor) {
        headerAccessor.getSessionAttributes().put("username", user.getUsername());
        OutputMessage message = new OutputMessage();
        message.setType(OutputMessage.Type.CONNECT);
        message.setText("joined");
        message.setSender(user.getUsername());
        return message;
    }
}
