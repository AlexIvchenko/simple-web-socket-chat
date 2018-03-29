package com.github.alexivchenko.chat.client.cli.converters;

import com.github.alexivchenko.chat.client.Help;

/**
 * @author Alex Ivchenko
 */
public class HelpConverter implements Converter<Help> {
    @Override
    public String convert(Help help) {
        StringBuilder str = new StringBuilder();
        for (String key : help.keys()) {
            str.append(key).append(" ").append(help.description(key)).append("\n");
        }
        return str.toString();
    }
}
