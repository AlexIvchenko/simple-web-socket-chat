package com.github.alexivchenko.chat.client.cli.mvc.controller.api;

import com.github.alexivchenko.chat.client.Channel;
import com.github.alexivchenko.chat.client.cli.Matcher;

/**
 * @author Alex Ivchenko
 */
public interface ChannelMessagingController {
    void create(String name);

    void list(Matcher<Channel> matcher);

    void join(Channel channel);

    void enter(Channel channel);
}
