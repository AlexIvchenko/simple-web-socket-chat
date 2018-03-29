package com.github.alexivchenko.chat.client.cli.mvc.model;

import com.github.alexivchenko.chat.client.Channel;
import com.github.alexivchenko.chat.client.Help;
import com.github.alexivchenko.chat.client.Message;
import com.github.alexivchenko.chat.client.User;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;

/**
 * @author Alex Ivchenko
 */
public class ModelImpl implements Model {
    private final Set<Consumer<List<User>>> usersListeners = new HashSet<>();
    private final Set<Consumer<List<Channel>>> channelsListeners = new HashSet<>();
    private final Set<Consumer<Help>> helpListeners = new HashSet<>();
    private final Set<Consumer<Message>> messageListeners = new HashSet<>();
    private final Set<Consumer<String>> errorListeners = new HashSet<>();

    @Override
    public void addUserList(List<User> users) {
        aware(users, usersListeners);
    }

    @Override
    public void addChannelList(List<Channel> channels) {
        aware(channels, channelsListeners);
    }

    @Override
    public void addHelp(Help help) {
        aware(help, helpListeners);
    }

    @Override
    public void addMessage(Message message) {
        aware(message, messageListeners);
    }

    @Override
    public void addError(String error) {
        aware(error, errorListeners);
    }

    private static <T> void aware(T obj, Set<Consumer<T>> listeners) {
        listeners.forEach(listener -> listener.accept(obj));
    }

    public void addUsersAppendingEventListener(Consumer<List<User>> userListener) {
        this.usersListeners.add(userListener);
    }

    public void addChannelsAppendingEventListener(Consumer<List<Channel>> channelsListener) {
        this.channelsListeners.add(channelsListener);
    }

    public void addHelpAppendingEventListener(Consumer<Help> helpListener) {
        this.helpListeners.add(helpListener);
    }

    public void addMessageAppendingEventListener(Consumer<Message> messageListener) {
        this.messageListeners.add(messageListener);
    }

    public void addErrorAppendingEventListener(Consumer<String> errorListener) {
        this.errorListeners.add(errorListener);
    }
}
