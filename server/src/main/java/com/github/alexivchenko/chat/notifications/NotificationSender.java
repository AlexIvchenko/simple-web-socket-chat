package com.github.alexivchenko.chat.notifications;

import com.github.alexivchenko.chat.auth.JwtAuthenticationToken;
import com.github.alexivchenko.chat.sender.MessagingEventNotifier;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.SessionConnectedEvent;
import org.springframework.web.socket.messaging.SessionDisconnectEvent;

/**
 * @author Alex Ivchenko
 */
@Slf4j
@Component
public class NotificationSender {
    private final MessagingEventNotifier notifier;

    public NotificationSender(MessagingEventNotifier notifier) {
        this.notifier = notifier;
    }

    @EventListener
    public void userConnectedEventHandler(SessionConnectedEvent event) {
        JwtAuthenticationToken token = (JwtAuthenticationToken) event.getUser();
        log.info("user connected: {}", token.getName());
        UserChannelNotification notification = UserChannelNotification.connected(token.getUsername());
        notifier.aware(notification);
    }

    @EventListener
    public void userDisconnectedEventHandler(SessionDisconnectEvent event) {
        JwtAuthenticationToken token = (JwtAuthenticationToken) event.getUser();
        log.info("user connected: {}", token.getName());
        UserChannelNotification notification = UserChannelNotification.disconnected(token.getUsername());
        notifier.aware(notification);
    }
}
