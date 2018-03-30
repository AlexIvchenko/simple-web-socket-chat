package com.github.alexivchenko.chat.client.cli.commands;

import com.github.alexivchenko.chat.client.User;
import com.github.alexivchenko.chat.client.cli.UserState;
import com.github.alexivchenko.chat.client.cli.context.ContextHolder;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Alex Ivchenko
 */
@Slf4j
public class StartChattingWithUserCommandFactory implements CommandFactory {
    private final ContextHolder holder;

    public StartChattingWithUserCommandFactory(ContextHolder holder) {
        this.holder = holder;
    }

    @Override
    public Command build(String str) {
        String username = str.substring(":chat ".length());
        log.info("username: " + username);
        User receiver = new User(username);
        return new StartChattingWithUserCommand(holder, receiver);
    }

    @Override
    public boolean supports(String str) {
        return str.startsWith(":chat");
    }

    @Override
    public boolean isAvailable() {
        return holder.context().getUserState() == UserState.INITIAL;
    }
}
