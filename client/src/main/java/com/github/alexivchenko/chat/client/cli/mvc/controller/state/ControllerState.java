package com.github.alexivchenko.chat.client.cli.mvc.controller.state;

import com.github.alexivchenko.chat.client.Channel;
import com.github.alexivchenko.chat.client.Message;
import com.github.alexivchenko.chat.client.User;
import com.github.alexivchenko.chat.client.cli.Matcher;

/**
 * @author Alex Ivchenko
 */
public interface ControllerState {
    default void help() {
        throw new UnsupportedOperationException("cannot get help");
    }

    default void signUp(String username, String password) {
        throw new UnsupportedOperationException("cannot sign up");
    }

    default void signIn(String username, String password) {
        throw new UnsupportedOperationException("cannot sign in");
    }

    default void signOut() {
        throw new UnsupportedOperationException("cannot sign out");
    }

    default void createChannel(String name) {
        throw new UnsupportedOperationException("cannot create channel");
    }

    default void listChannels(Matcher<Channel> matcher) {
        throw new UnsupportedOperationException("cannot list channels");
    }

    default void join(Channel channel) {
        throw new UnsupportedOperationException("cannot join channel");
    }

    default void enter(Channel channel) {
        throw new UnsupportedOperationException("cannot enter to channel");
    }

    default void users(Matcher<User> matcher) {
        throw new UnsupportedOperationException("cannot list users");
    }

    default void startChatting(User user) {
        throw new UnsupportedOperationException("cannot start chatting");
    }

    default void error(String error) {
        throw new UnsupportedOperationException();
    }

    default void send(Message message) {
        throw new UnsupportedOperationException("cannot send");
    }

    default void leave() {
        throw new UnsupportedOperationException("cannot leave");
    }
}
