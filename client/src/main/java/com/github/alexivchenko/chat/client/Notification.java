package com.github.alexivchenko.chat.client;

import lombok.Getter;
import lombok.Setter;

/**
 * @author Alex Ivchenko
 */
@Getter
@Setter
public class Notification {
    private String username;
    private Type type;

    public enum Type {
        USER_CONNECTED, USER_DISCONNECTED, USER_SUBSCRIBED, USER_UNSUBSCRIBED
    }

    @Override
    public String toString() {
        switch (type) {
            case USER_CONNECTED:
                return username + " connected";
            case USER_DISCONNECTED:
                return username + " disconnected";
            case USER_SUBSCRIBED:
                return username + " subscribed";
            case USER_UNSUBSCRIBED:
                return username + "unsubscribed";
            default: throw new RuntimeException();
        }
    }
}
