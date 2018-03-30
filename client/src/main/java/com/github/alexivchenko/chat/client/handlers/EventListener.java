package com.github.alexivchenko.chat.client.handlers;

/**
 * @author Alex Ivchenko
 */
public interface EventListener<T> {
    void handle(T event);
}
