package com.github.alexivchenko.chat.client.cli.commands;

import com.github.alexivchenko.chat.client.Channel;
import com.github.alexivchenko.chat.client.Message;
import com.github.alexivchenko.chat.client.Sender;
import com.github.alexivchenko.chat.client.User;
import com.github.alexivchenko.chat.client.cli.UserState;
import com.github.alexivchenko.chat.client.cli.context.ContextHolder;

/**
 * @author Alex Ivchenko
 */
public class SendCommandFactory implements CommandFactory {
    private final ContextHolder contextHolder;
    private final Sender sender;

    public SendCommandFactory(ContextHolder contextHolder, Sender sender) {
        this.contextHolder = contextHolder;
        this.sender = sender;
    }

    @Override
    public Command build(String str) {
        Message message = new Message(str.substring(":send ".length()));
        if (state() == UserState.CHATTING_WITH_USER) {
            return SendCommand
                    .to(receiver())
                    .send(message)
                    .using(sender);
        } else if (state() == UserState.CHATTING_IN_CHANNEL) {
            return SendCommand
                    .to(channel())
                    .send(message)
                    .using(sender);
        } else {
            throw new RuntimeException();
        }
    }

    private User receiver() {
        return contextHolder.context().getReceiver();
    }

    private Channel channel() {
        return contextHolder.context().getChannel();
    }

    @Override
    public boolean supports(String str) {
        return str.startsWith(":send");
    }

    @Override
    public boolean isAvailable() {
        UserState state = state();
        return state == UserState.CHATTING_IN_CHANNEL || state == UserState.CHATTING_WITH_USER;
    }

    private UserState state() {
        return contextHolder.context().getUserState();
    }
}
