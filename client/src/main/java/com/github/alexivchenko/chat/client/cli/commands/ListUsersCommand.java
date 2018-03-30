package com.github.alexivchenko.chat.client.cli.commands;

import com.github.alexivchenko.chat.client.User;
import com.github.alexivchenko.chat.client.service.UserService;

import java.util.List;
import java.util.function.Consumer;

/**
 * @author Alex Ivchenko
 */
public class ListUsersCommand implements Command {
    private final UserService userService;
    private final Consumer<List<User>> usersConsumer;

    public ListUsersCommand(UserService userService, Consumer<List<User>> usersConsumer) {
        this.userService = userService;
        this.usersConsumer = usersConsumer;
    }

    @Override
    public void run() {
        usersConsumer.accept(userService.users());
    }
}
