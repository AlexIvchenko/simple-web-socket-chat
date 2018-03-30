package com.github.alexivchenko.chat.channel;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

/**
 * @author Alex Ivchenko
 */
@Slf4j
@RestController
public class ChannelController {
    private final ChannelService service;

    public ChannelController(ChannelService service) {
        this.service = service;
    }

    @PostMapping("/api/channels")
    public Channel create(@RequestBody Channel channel) {
        return service.create(channel);
    }

    @GetMapping("/api/channels")
    public Set<Channel> getAll() {
        return service.getAll();
    }
}
