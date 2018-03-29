package com.github.alexivchenko.chat.client.handlers;

import com.github.alexivchenko.chat.client.Notification;
import org.springframework.messaging.simp.stomp.StompHeaders;
import org.springframework.messaging.simp.stomp.StompSession;
import org.springframework.messaging.simp.stomp.StompSessionHandlerAdapter;

import java.lang.reflect.Type;

/**
 * @author Alex Ivchenko
 */
public class NotificationHandler extends StompSessionHandlerAdapter {
    @Override
    public Type getPayloadType(StompHeaders headers) {
        return Notification.class;
    }

    @Override
    public void afterConnected(StompSession session, StompHeaders connectedHeaders) {
        System.out.println("New session established : " + session.getSessionId());
        session.subscribe("/topic/notifications", this);
        System.out.println("Subscribed to /topic/notifications");
    }

    @Override
    public void handleFrame(StompHeaders headers, Object payload) {
        Notification notification = (Notification) payload;
        System.out.println(notification);
    }
}
