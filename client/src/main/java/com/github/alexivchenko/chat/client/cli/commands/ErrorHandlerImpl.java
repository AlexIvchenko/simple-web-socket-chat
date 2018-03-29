package com.github.alexivchenko.chat.client.cli.commands;

import com.github.alexivchenko.chat.client.cli.mvc.controller.api.Controller;

/**
 * @author Alex Ivchenko
 */
public class ErrorHandlerImpl implements ErrorHandler {
    private final Controller controller;

    public ErrorHandlerImpl(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void handle(Exception exc) {
        controller.error(exc.getMessage());
    }
}
