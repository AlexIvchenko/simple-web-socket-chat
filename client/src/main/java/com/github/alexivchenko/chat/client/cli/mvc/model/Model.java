package com.github.alexivchenko.chat.client.cli.mvc.model;

import com.github.alexivchenko.chat.client.Channel;
import com.github.alexivchenko.chat.client.Help;
import com.github.alexivchenko.chat.client.Message;
import com.github.alexivchenko.chat.client.User;

import java.util.List;

/**
 * @author Alex Ivchenko
 */
public interface Model {
    void addUserList(List<User> users);

    void addChannelList(List<Channel> channels);

    void addHelp(Help help);

    void addMessage(Message message);

    void addError(String error);
}
