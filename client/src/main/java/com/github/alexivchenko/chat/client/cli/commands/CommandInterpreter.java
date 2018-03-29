package com.github.alexivchenko.chat.client.cli.commands;

/**
 * @author Alex Ivchenko
 */
public interface CommandInterpreter {
    void interpret(String str);

    interface Fallback {
        void fallback(Exception e);
    }
}
