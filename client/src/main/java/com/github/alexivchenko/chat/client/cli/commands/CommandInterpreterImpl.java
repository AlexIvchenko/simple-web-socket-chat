package com.github.alexivchenko.chat.client.cli.commands;

/**
 * @author Alex Ivchenko
 */
public class CommandInterpreterImpl implements CommandInterpreter {
    private final CommandBuilder builder;
    private final DefaultCommandGenerator generator;

    public CommandInterpreterImpl(CommandBuilder builder, DefaultCommandGenerator generator) {
        this.builder = builder;
        this.generator = generator;
    }

    @Override
    public void interpret(String str) {
        if (!str.startsWith(":")) {
            str = generator.generateCommand(str);
        }
        builder.command(str).run();
    }
}
