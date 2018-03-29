package com.github.alexivchenko.chat.client.cli.mvc.controller.state;

import com.github.alexivchenko.chat.client.cli.mvc.model.Model;

/**
 * @author Alex Ivchenko
 */
public abstract class BaseControllerState implements ControllerState {
    private final Model model;

    public BaseControllerState(Model model) {
        this.model = model;
    }

    @Override
    public void error(String error) {
        model.addError(error);
    }
}
