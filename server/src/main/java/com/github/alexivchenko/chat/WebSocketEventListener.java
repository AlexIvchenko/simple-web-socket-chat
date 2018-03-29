package com.github.alexivchenko.chat;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;

/**
 * @author Alex Ivchenko
 */
@Slf4j
@Component
public class WebSocketEventListener {
    private final SimpMessageSendingOperations messagingTemplate;

    public WebSocketEventListener(SimpMessageSendingOperations messagingTemplate) {
        this.messagingTemplate = messagingTemplate;
    }

//    @EventListener
//    public void handleWebSocketConnectListener(SessionConnectedEvent event) {
//        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
//        String username = (String) headerAccessor.getSessionAttributes().get("username");
//        if(username != null) {
//            log.info("User connected : " + username);
//            OutputMessage message = new OutputMessage();
//            message.setType(OutputMessage.Type.CONNECT);
//            message.setSender(username);
//            messagingTemplate.convertAndSend("/topic/messages", message);
//        }
//    }

//    @EventListener
//    public void handleWebSocketDisconnectListener(SessionDisconnectEvent event) {
//        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(event.getMessage());
//        String username = (String) headerAccessor.getSessionAttributes().get("username");
//        if(username != null) {
//            log.info("User disconnected : " + username);
//            OutputMessage message = new OutputMessage();
//            message.setType(OutputMessage.Type.DISCONNECT);
//            message.setSender(username);
//            messagingTemplate.convertAndSend("/topic/messages", message);
//        }
//    }
}
