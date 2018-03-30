package com.github.alexivchenko.chat.client.cli.commands;

import com.github.alexivchenko.chat.client.User;
import com.github.alexivchenko.chat.client.cli.UserState;
import com.github.alexivchenko.chat.client.cli.context.ContextHolder;
import com.github.alexivchenko.chat.client.service.UserService;

import java.util.List;
import java.util.function.Consumer;

/**
 * @author Alex Ivchenko
 */
public class ListUsersCommandFactory implements CommandFactory {
    private final ContextHolder holder;
    private final UserService userService;
    private final Consumer<List<User>> usersConsumer;

    public ListUsersCommandFactory(ContextHolder holder, UserService userService, Consumer<List<User>> usersConsumer) {
        this.holder = holder;
        this.userService = userService;
        this.usersConsumer = usersConsumer;
    }

    @Override
    public Command build(String str) {
        return new ListUsersCommand(userService, usersConsumer);
    }

    @Override
    public boolean supports(String str) {
        return str.startsWith(":users");
    }

    @Override
    public boolean isAvailable() {
        UserState state = holder.context().getUserState();
        return state == UserState.INITIAL || state == UserState.CHATTING_IN_CHANNEL;
    }
}
