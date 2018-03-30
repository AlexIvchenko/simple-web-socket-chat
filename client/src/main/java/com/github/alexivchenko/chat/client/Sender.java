package com.github.alexivchenko.chat.client;

/**
 * @author Alex Ivchenko
 */
public interface Sender {
    void send(Channel channel, Message message);

    void send(User user, Message message);
}
