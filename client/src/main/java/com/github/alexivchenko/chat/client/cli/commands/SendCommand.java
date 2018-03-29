package com.github.alexivchenko.chat.client.cli.commands;

import com.github.alexivchenko.chat.client.Message;
import com.github.alexivchenko.chat.client.cli.mvc.controller.api.Controller;

/**
 * @author Alex Ivchenko
 */
public class SendCommand implements Command {
    private final Controller controller;
    private final Message message;

    public SendCommand(Controller controller, Message message) {
        this.controller = controller;
        this.message = message;
    }

    @Override
    public void run() {
        controller.send(message);
    }
}
