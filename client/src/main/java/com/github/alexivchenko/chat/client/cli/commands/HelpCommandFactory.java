package com.github.alexivchenko.chat.client.cli.commands;

import com.github.alexivchenko.chat.client.cli.mvc.controller.api.Controller;

/**
 * @author Alex Ivchenko
 */
public class HelpCommandFactory implements CommandFactory {
    private final Controller controller;

    public HelpCommandFactory(Controller controller) {
        this.controller = controller;
    }

    @Override
    public Command build(String str) {
        if (!supports(str)) {
            throw new IllegalArgumentException("cannot parse string: " + str);
        }
        return new HelpCommand(controller);
    }

    @Override
    public boolean supports(String str) {
        return str.equals(":help");
    }
}
