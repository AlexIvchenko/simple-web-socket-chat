package com.github.alexivchenko.chat.client.cli;

/**
 * @author Alex Ivchenko
 */
public interface Matcher<T> {
    boolean match(T obj);
}