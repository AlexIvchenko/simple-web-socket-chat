package com.github.alexivchenko.chat.client.cli.converters;

/**
 * @author Alex Ivchenko
 */
public interface Converter<T> {
    String convert(T obj);
}
