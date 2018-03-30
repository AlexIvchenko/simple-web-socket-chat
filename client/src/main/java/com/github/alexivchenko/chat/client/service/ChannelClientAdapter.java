package com.github.alexivchenko.chat.client.service;

import com.github.alexivchenko.chat.client.Channel;
import com.github.alexivchenko.chat.client.service.feign.ChannelClient;

import java.util.Set;

/**
 * @author Alex Ivchenko
 */
public class ChannelClientAdapter implements ChannelService {
    private final ChannelClient channelClient;

    public ChannelClientAdapter(ChannelClient channelClient) {
        this.channelClient = channelClient;
    }

    @Override
    public Channel create(Channel channel) {
        return channelClient.create(channel);
    }

    @Override
    public Set<Channel> getAll() {
        return channelClient.getAll();
    }
}
