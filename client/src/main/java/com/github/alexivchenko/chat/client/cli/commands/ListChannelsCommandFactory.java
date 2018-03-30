package com.github.alexivchenko.chat.client.cli.commands;

import com.github.alexivchenko.chat.client.Channel;
import com.github.alexivchenko.chat.client.cli.UserState;
import com.github.alexivchenko.chat.client.cli.context.ContextHolder;
import com.github.alexivchenko.chat.client.service.ChannelService;

import java.util.Set;
import java.util.function.Consumer;

/**
 * @author Alex Ivchenko
 */
public class ListChannelsCommandFactory implements CommandFactory {
    private final ContextHolder holder;
    private final ChannelService service;
    private final Consumer<Set<Channel>> channelsConsumer;

    public ListChannelsCommandFactory(ContextHolder holder, ChannelService service, Consumer<Set<Channel>> channelsConsumer) {
        this.holder = holder;
        this.service = service;
        this.channelsConsumer = channelsConsumer;
    }

    @Override
    public Command build(String str) {
        return new ListChannelsCommand(holder, service, channelsConsumer);
    }

    @Override
    public boolean supports(String str) {
        return str.startsWith(":channels") && !str.startsWith(":channels -c");
    }

    @Override
    public boolean isAvailable() {
        UserState state = holder.context().getUserState();
        return state == UserState.INITIAL;
    }
}
