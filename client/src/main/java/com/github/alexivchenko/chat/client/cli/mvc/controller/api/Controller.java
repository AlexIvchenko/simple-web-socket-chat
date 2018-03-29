package com.github.alexivchenko.chat.client.cli.mvc.controller.api;

import com.github.alexivchenko.chat.client.Message;
import com.github.alexivchenko.chat.client.User;
import com.github.alexivchenko.chat.client.cli.Matcher;

/**
 * @author Alex Ivchenko
 */
public interface Controller {
    AuthController auth();

    DirectMessagingController direct();

    ChannelMessagingController channel();

    void help();

    void users(Matcher<User> matcher);

    void error(String error);

    void send(Message message);
}