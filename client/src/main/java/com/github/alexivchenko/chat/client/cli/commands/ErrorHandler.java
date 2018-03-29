package com.github.alexivchenko.chat.client.cli.commands;

/**
 * @author Alex Ivchenko
 */
public interface ErrorHandler {
    void handle(Exception exc);
}
