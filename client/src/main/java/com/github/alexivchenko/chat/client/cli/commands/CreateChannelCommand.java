package com.github.alexivchenko.chat.client.cli.commands;

import com.github.alexivchenko.chat.client.Channel;
import com.github.alexivchenko.chat.client.service.ChannelService;

/**
 * @author Alex Ivchenko
 */
public class CreateChannelCommand implements Command {
    private final ChannelService service;
    private final Channel channel;

    public CreateChannelCommand(ChannelService service, Channel channel) {
        this.service = service;
        this.channel = channel;
    }

    @Override
    public void run() {
        service.create(channel);
    }
}
