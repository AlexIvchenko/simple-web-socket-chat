package com.github.alexivchenko.chat.client.cli.commands;

import com.github.alexivchenko.chat.client.cli.mvc.controller.api.Controller;

/**
 * @author Alex Ivchenko
 */
public class SendCommandFactory implements CommandFactory {
    private final Controller controller;

    public SendCommandFactory(Controller controller) {
        this.controller = controller;
    }

    // TODO parse message from str
    @Override
    public Command build(String str) {
        return new SendCommand(controller, null);
    }

    @Override
    public boolean supports(String str) {
        return str.startsWith(":send");
    }
}
