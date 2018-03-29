package com.github.alexivchenko.chat.client.cli.commands;

import com.github.alexivchenko.chat.client.cli.mvc.controller.api.Controller;

/**
 * @author Alex Ivchenko
 */
public class FallbackCommand implements Command {
    private final Controller controller;

    public FallbackCommand(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void run() {
        controller.error("wrong command");
    }
}
