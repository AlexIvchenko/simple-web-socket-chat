package com.github.alexivchenko.chat.client;

import lombok.ToString;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author Alex Ivchenko
 */
@ToString
public class Help {
    private final Map<String, String> helps = new HashMap<>();

    public Help add(String command, String description) {
        helps.put(command, description);
        return this;
    }

    public Set<String> keys() {
        return helps.keySet();
    }

    public String description(String key) {
        return helps.get(key);
    }
}
