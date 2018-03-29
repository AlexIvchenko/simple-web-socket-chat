package com.github.alexivchenko.chat.notifications;

import com.github.alexivchenko.chat.auth.JwtAuthenticationToken;
import com.github.alexivchenko.chat.sender.MessagingEventNotifier;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.messaging.*;

/**
 * @author Alex Ivchenko
 */
@Slf4j
@Component
public class NotificationSender {
    private static final String SIMP_DESTINATION = "simpDestination";
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

    @EventListener
    public void userSubscribeEventHandler(SessionSubscribeEvent event) {
        JwtAuthenticationToken token = (JwtAuthenticationToken) event.getUser();
        String destination = (String) event.getMessage().getHeaders().get(SIMP_DESTINATION);
        log.info("user {} subscribed to {}", token.getName(), destination);
        UserChannelNotification notification = UserChannelNotification.subscribed(token.getUsername());
        if (destination.contains("messages")) {
            notifier.aware(notification);
        }
    }

    @EventListener
    public void userUnsubscribeEventHandler(SessionUnsubscribeEvent event) {
        JwtAuthenticationToken token = auth(event);
        String destination = destination(event);
        log.info("user {} subscribed to {}", token.getName(), destination);
        UserChannelNotification notification = UserChannelNotification.unsubscribed(token.getUsername());
        if (destination.contains("messages")) {
            notifier.aware(notification);
        }
    }

    private JwtAuthenticationToken auth(AbstractSubProtocolEvent event) {
        return (JwtAuthenticationToken) event.getUser();
    }

    private String destination(AbstractSubProtocolEvent event) {
        return (String) event.getMessage().getHeaders().get(SIMP_DESTINATION);
    }
}
