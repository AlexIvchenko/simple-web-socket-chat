package com.github.alexivchenko.chat.sender;

import com.github.alexivchenko.chat.notifications.UserChannelNotification;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.simp.SimpMessageSendingOperations;
import org.springframework.stereotype.Component;

/**
 * @author Alex Ivchenko
 */
@Slf4j
@Component
public class MessagingEventNotifierImpl implements MessagingEventNotifier {
    private final SimpMessageSendingOperations messaging;

    public MessagingEventNotifierImpl(SimpMessageSendingOperations messaging) {
        this.messaging = messaging;
    }

    @Override
    public void aware(UserChannelNotification notification) {
        log.info("sending notification");
        messaging.convertAndSend("/topic/notifications", notification);
    }
}
