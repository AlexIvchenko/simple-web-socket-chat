package com.github.alexivchenko.chat.user;

import org.springframework.messaging.simp.user.SimpUserRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Alex Ivchenko
 */
@RestController
public class UserController {
    private final SimpUserRegistry registry;

    public UserController(SimpUserRegistry registry) {
        this.registry = registry;
    }

    @GetMapping("/api/channels/{channel}/users")
    public List<User> getSubscribedUsers(@PathVariable("channel") String channel) {
        return registry.findSubscriptions(subscription -> subscription.getDestination().contains(channel)).stream()
                .map(sub -> new User(sub.getSession().getUser().getName()))
                .collect(Collectors.toList());
    }

    @GetMapping("/api/users")
    public List<User> getUsers() {
        return registry.getUsers().stream()
                .map(sub -> new User(sub.getName()))
                .collect(Collectors.toList());
    }
}
