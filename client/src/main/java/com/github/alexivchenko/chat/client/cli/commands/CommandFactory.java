package com.github.alexivchenko.chat.client.cli.commands;

/**
 * @author Alex Ivchenko
 */
public interface CommandFactory {
    Command build(String str);

    boolean supports(String str);
}
