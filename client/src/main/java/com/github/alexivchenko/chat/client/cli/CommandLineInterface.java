package com.github.alexivchenko.chat.client.cli;

import com.github.alexivchenko.chat.client.Help;
import com.github.alexivchenko.chat.client.Sender;
import com.github.alexivchenko.chat.client.cli.commands.*;
import com.github.alexivchenko.chat.client.cli.context.ContextHolder;
import com.github.alexivchenko.chat.client.cli.converters.Converters;
import com.github.alexivchenko.chat.client.cli.converters.HelpConverter;
import com.github.alexivchenko.chat.client.cli.converters.MapConverters;

/**
 * @author Alex Ivchenko
 */
public class CommandLineInterface {
    private final Sender sender;
    private final ContextHolder contextHolder = new ContextHolderImpl();

    public CommandLineInterface(Sender sender) {
        this.sender = sender;
    }

    public void run() {
        Converters converters = converters();

        CommandBuilder commandBuilder = ListFactoriesCommandBuilder.builder()
                .add(new SendCommandFactory(contextHolder, sender))
                .setFallback(() -> {})
                .build();

        CommandInterpreter interpreter = new CommandInterpreterImpl(commandBuilder, new SendAsDefaultCommandGenerator());
        CommandReader reader = new CommandReader(interpreter, System.in);
        reader.start();
    }

    private MapConverters converters() {
        MapConverters converters = new MapConverters();
        converters.add(Help.class, new HelpConverter());
        return converters;
    }
}
