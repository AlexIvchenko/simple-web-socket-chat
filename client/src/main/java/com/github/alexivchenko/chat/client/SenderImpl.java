package com.github.alexivchenko.chat.client;

import org.springframework.messaging.simp.stomp.StompSession;

/**
 * @author Alex Ivchenko
 */
public class SenderImpl implements Sender {
    private final StompSession session;
    private final User currentUser;

    public SenderImpl(StompSession session, User currentUser) {
        this.session = session;
        this.currentUser = currentUser;
    }

    @Override
    public void send(Channel channel, Message message) {
        session.send("/app/chat/channels/" + channel.getName(), message);
    }

    @Override
    public void send(User user, Message message) {
        session.send("/app/chat/direct/" + user.getUsername(), message);
        session.send("/app/chat/direct/" + currentUser.getUsername(), message);
    }
}
