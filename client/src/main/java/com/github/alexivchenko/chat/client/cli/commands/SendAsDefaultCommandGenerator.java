package com.github.alexivchenko.chat.client.cli.commands;

/**
 * @author Alex Ivchenko
 */
public class SendAsDefaultCommandGenerator implements DefaultCommandGenerator {
    @Override
    public String generateCommand(String str) {
        return ":send " + str;
    }
}
