package com.github.alexivchenko.chat.client.cli.mvc.controller.impl;

import com.github.alexivchenko.chat.client.cli.mvc.controller.state.StatableController;
import com.github.alexivchenko.chat.client.cli.mvc.controller.api.AuthController;

/**
 * @author Alex Ivchenko
 */
public class AuthControllerImpl implements AuthController {
    private final StatableController controller;

    public AuthControllerImpl(StatableController controller) {
        this.controller = controller;
    }

    @Override
    public void signUp(String username, String password) {
        controller.getState().signUp(username, password);
    }

    @Override
    public void signIn(String username, String password) {
        controller.getState().signIn(username, password);
    }

    @Override
    public void signOut() {
        controller.getState().signOut();
    }
}
