package com.github.alexivchenko.chat.client.cli.converters;

/**
 * @author Alex Ivchenko
 */
public interface Converters {
    <T> Converter<T> converter(Class<T> type);
}
