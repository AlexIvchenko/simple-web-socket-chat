package com.github.alexivchenko.chat.channel;

import java.util.Set;

/**
 * @author Alex Ivchenko
 */
public interface ChannelService {
    Channel create(Channel channel);

    Set<Channel> getAll();
}
