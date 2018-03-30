package com.github.alexivchenko.chat.channel;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

/**
 * @author Alex Ivchenko
 */
public interface ChannelRepository extends CrudRepository<Channel, UUID> {
    Channel findByName(String name);
}
