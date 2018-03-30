package com.github.alexivchenko.chat.client.service;

import com.github.alexivchenko.chat.client.User;
import com.github.alexivchenko.chat.client.service.feign.UserClient;

import java.util.List;

/**
 * @author Alex Ivchenko
 */
public class UserClientAdapter implements UserService {
    private final UserClient client;

    public UserClientAdapter(UserClient client) {
        this.client = client;
    }

    @Override
    public List<User> users() {
        return client.users();
    }
}
