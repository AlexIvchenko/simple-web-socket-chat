package com.github.alexivchenko.chat.channel;

import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Alex Ivchenko
 */
@Service
public class ChannelServiceImpl implements ChannelService {
    private final ChannelRepository channelRepository;

    public ChannelServiceImpl(ChannelRepository channelRepository) {
        this.channelRepository = channelRepository;
    }

    @Override
    public Channel create(Channel channel) {
        return channelRepository.save(channel);
    }

    @Override
    public Set<Channel> getAll() {
        Set<Channel> channels = new HashSet<>();
        channelRepository.findAll().forEach(channels::add);
        return channels;
    }
}
