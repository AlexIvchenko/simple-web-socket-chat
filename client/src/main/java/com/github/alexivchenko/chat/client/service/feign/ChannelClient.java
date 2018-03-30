package com.github.alexivchenko.chat.client.service.feign;

import com.github.alexivchenko.chat.client.Channel;
import feign.Headers;
import feign.RequestLine;

import java.util.Set;

/**
 * @author Alex Ivchenko
 */
public interface ChannelClient {
    @RequestLine("POST")
    @Headers("Content-Type: application/json")
    Channel create(Channel channel);

    @RequestLine("GET")
    @Headers("Content-Type: application/json")
    Set<Channel> getAll();
}
