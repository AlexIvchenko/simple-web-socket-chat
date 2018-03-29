package com.github.alexivchenko.chat.sender;

import com.github.alexivchenko.chat.notifications.UserChannelNotification;

/**
 * @author Alex Ivchenko
 */
public interface MessagingEventNotifier {
    void aware(UserChannelNotification notification);
}
