package com.github.alexivchenko.chat.client.cli.commands;

import com.github.alexivchenko.chat.client.Channel;
import com.github.alexivchenko.chat.client.cli.context.ContextHolder;
import com.github.alexivchenko.chat.client.service.ChannelService;

import java.util.Set;
import java.util.function.Consumer;

/**
 * @author Alex Ivchenko
 */
public class ListChannelsCommand implements Command {
    private final ContextHolder holder;
    private final ChannelService service;
    private final Consumer<Set<Channel>> channelsConsumer;

    public ListChannelsCommand(ContextHolder holder, ChannelService service, Consumer<Set<Channel>> channelsConsumer) {
        this.holder = holder;
        this.service = service;
        this.channelsConsumer = channelsConsumer;
    }

    @Override
    public void run() {
        channelsConsumer.accept(service.getAll());
    }
}
