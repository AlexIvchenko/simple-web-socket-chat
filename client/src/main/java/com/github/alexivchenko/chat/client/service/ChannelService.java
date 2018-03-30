package com.github.alexivchenko.chat.client.service;

import com.github.alexivchenko.chat.client.Channel;

import java.util.Set;

/**
 * @author Alex Ivchenko
 */
public interface ChannelService {
    Channel create(Channel channel);

    Set<Channel> getAll();
}
