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
        USER_CONNECTED, USER_DISCONNECTED
    }

    @Override
    public String toString() {
        if (type == Type.USER_CONNECTED) {
            return username + " connected";
        } else {
            return username + " disconnected";
        }
    }
}
