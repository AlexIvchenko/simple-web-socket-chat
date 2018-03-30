package com.github.alexivchenko.chat.client.handlers;

/**
 * @author Alex Ivchenko
 */
public class Event<T> {
    private final T data;

    public Event(T data) {
        this.data = data;
    }

    public T get() {
        return data;
    }
}
