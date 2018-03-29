package com.github.alexivchenko.chat.notifications;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Alex Ivchenko
 */
@Getter
@Setter
@AllArgsConstructor
public class UserChannelNotification {
    private String username;
    private Type type;

    public enum Type {
        USER_CONNECTED, USER_DISCONNECTED, USER_SUBSCRIBED, USER_UNSUBSCRIBED
    }

    public static UserChannelNotification subscribed(String username) {
        return new UserChannelNotification(username, Type.USER_SUBSCRIBED);
    }

    public static UserChannelNotification unsubscribed(String username) {
        return new UserChannelNotification(username, Type.USER_UNSUBSCRIBED);
    }

    public static UserChannelNotification connected(String username) {
        return new UserChannelNotification(username, Type.USER_CONNECTED);
    }

    public static UserChannelNotification disconnected(String username) {
        return new UserChannelNotification(username, Type.USER_DISCONNECTED);
    }
}
