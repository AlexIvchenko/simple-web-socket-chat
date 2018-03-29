package com.github.alexivchenko.chat.client.cli.converters;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Alex Ivchenko
 */
public class MapConverters implements Converters {
    private final Map<Class, Converter> converters = new HashMap<>();

    public <T> MapConverters add(Class<T> type, Converter<T> converter) {
        converters.put(type, converter);
        return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    public <T> Converter<T> converter(Class<T> type) {
        return converters.get(type);
    }
}
