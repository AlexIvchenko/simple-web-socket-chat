package com.github.alexivchenko.chat.client.cli.mvc.controller.state;

import com.github.alexivchenko.chat.client.Channel;
import com.github.alexivchenko.chat.client.User;
import com.github.alexivchenko.chat.client.cli.Matcher;

/**
 * @author Alex Ivchenko
 */
public class InitialControllerState implements ControllerState {
    private final StatableController controller;

    public InitialControllerState(StatableController controller) {
        this.controller = controller;
    }

    @Override
    public void signOut() {

    }

    @Override
    public void createChannel(String name) {

    }

    @Override
    public void listChannels(Matcher<Channel> matcher) {

    }

    @Override
    public void join(Channel channel) {

    }

    @Override
    public void enter(Channel channel) {

    }

    @Override
    public void users(Matcher<User> matcher) {

    }

    @Override
    public void startChatting(User user) {

    }
}
