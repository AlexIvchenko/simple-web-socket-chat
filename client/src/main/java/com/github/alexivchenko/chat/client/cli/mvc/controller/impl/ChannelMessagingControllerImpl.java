package com.github.alexivchenko.chat.client.cli.mvc.controller.impl;

import com.github.alexivchenko.chat.client.Channel;
import com.github.alexivchenko.chat.client.cli.Matcher;
import com.github.alexivchenko.chat.client.cli.mvc.controller.state.StatableController;
import com.github.alexivchenko.chat.client.cli.mvc.controller.api.ChannelMessagingController;

/**
 * @author Alex Ivchenko
 */
public class ChannelMessagingControllerImpl implements ChannelMessagingController {
    private final StatableController controller;

    public ChannelMessagingControllerImpl(StatableController controller) {
        this.controller = controller;
    }

    @Override
    public void create(String name) {
        controller.getState().createChannel(name);
    }

    @Override
    public void list(Matcher<Channel> matcher) {
        controller.getState().listChannels(matcher);
    }

    @Override
    public void join(Channel channel) {
        controller.getState().join(channel);
    }

    @Override
    public void enter(Channel channel) {
        controller.getState().enter(channel);
    }
}
