package com.github.alexivchenko.chat.client.cli;

import com.github.alexivchenko.chat.client.Help;
import com.github.alexivchenko.chat.client.cli.commands.*;
import com.github.alexivchenko.chat.client.cli.converters.Converters;
import com.github.alexivchenko.chat.client.cli.converters.HelpConverter;
import com.github.alexivchenko.chat.client.cli.converters.MapConverters;
import com.github.alexivchenko.chat.client.cli.mvc.controller.impl.ControllerImpl;
import com.github.alexivchenko.chat.client.cli.commands.ErrorHandler;
import com.github.alexivchenko.chat.client.cli.commands.ErrorHandlerImpl;
import com.github.alexivchenko.chat.client.cli.mvc.controller.api.Controller;
import com.github.alexivchenko.chat.client.cli.mvc.model.Model;
import com.github.alexivchenko.chat.client.cli.mvc.model.ModelImpl;
import com.github.alexivchenko.chat.client.cli.mvc.view.CliView;
import com.github.alexivchenko.chat.client.cli.mvc.view.CliViewImpl;

/**
 * @author Alex Ivchenko
 */
public class CommandLineInterface {
    public void run() {
        CliView view = new CliViewImpl();
        Converters converters = converters();
        Model model = model(view, converters);
        Controller controller = controller(model);

        Command fallback = new FallbackCommand(controller);

        ErrorHandler handler = new ErrorHandlerImpl(controller);

        CommandBuilder commandBuilder = ListFactoriesCommandBuilder.builder()
                .add(new ErrorHandleCommandFactory(new HelpCommandFactory(controller), handler))
                .add(new ErrorHandleCommandFactory(new SendCommandFactory(controller), handler))
                .setFallback(fallback)
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

    private Model model(CliView view, Converters converters) {
        ModelImpl model = new ModelImpl();
        model.addHelpAppendingEventListener(help -> view.println(converters.converter(Help.class).convert(help)));
        model.addErrorAppendingEventListener(view::println);
        // TODO add listeners
        return model;
    }

    private Controller controller(Model model) {
        return new ControllerImpl(model);
    }
}
