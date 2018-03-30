package com.github.alexivchenko.chat.client.cli.commands;

import com.github.alexivchenko.chat.client.User;
import com.github.alexivchenko.chat.client.cli.UserState;
import com.github.alexivchenko.chat.client.cli.context.ContextHolder;

/**
 * @author Alex Ivchenko
 */
public class StartChattingWithUserCommand implements Command {
    private final ContextHolder holder;
    private final User receiver;

    public StartChattingWithUserCommand(ContextHolder holder, User receiver) {
        this.holder = holder;
        this.receiver = receiver;
    }

    @Override
    public void run() {
        holder.context().setUserState(UserState.CHATTING_WITH_USER);
        holder.context().setReceiver(receiver);
    }
}
