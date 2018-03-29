package com.github.alexivchenko.chat.client.cli.mvc.controller.state;

import com.github.alexivchenko.chat.client.Message;
import com.github.alexivchenko.chat.client.cli.mvc.model.Model;

/**
 * @author Alex Ivchenko
 */
public class ChattingWithUserControllerState extends BaseControllerState {
    private final StatableController controller;
    private final Model model;

    public ChattingWithUserControllerState(StatableController controller, Model model) {
        super(model);
        this.model = model;
        this.controller = controller;
    }

    @Override
    public void send(Message message) {

    }

    @Override
    public void leave() {

    }
}
