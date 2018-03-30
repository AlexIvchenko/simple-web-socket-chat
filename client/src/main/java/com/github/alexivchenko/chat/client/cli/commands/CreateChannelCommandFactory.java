package com.github.alexivchenko.chat.client.cli.commands;

import com.github.alexivchenko.chat.client.Channel;
import com.github.alexivchenko.chat.client.cli.UserState;
import com.github.alexivchenko.chat.client.cli.context.ContextHolder;
import com.github.alexivchenko.chat.client.service.ChannelService;

/**
 * @author Alex Ivchenko
 */
public class CreateChannelCommandFactory implements CommandFactory {
    private final ContextHolder holder;
    private final ChannelService service;

    public CreateChannelCommandFactory(ContextHolder holder, ChannelService service) {
        this.holder = holder;
        this.service = service;
    }

    @Override
    public Command build(String str) {
        Channel channel = new Channel(str.substring(":channels -c ".length()));
        return new CreateChannelCommand(service, channel);
    }

    @Override
    public boolean supports(String str) {
        return str.startsWith(":channels -c ");
    }

    @Override
    public boolean isAvailable() {
        UserState state = holder.context().getUserState();
        return state == UserState.INITIAL;
    }
}
