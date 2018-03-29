package com.github.alexivchenko.chat.client.cli.mvc.controller.state;

import com.github.alexivchenko.chat.client.Help;
import com.github.alexivchenko.chat.client.cli.mvc.model.Model;

/**
 * @author Alex Ivchenko
 */
public class UnauthorizedControllerState extends BaseControllerState {
    private final StatableController controller;
    private final Model model;

    public UnauthorizedControllerState(StatableController controller, Model model) {
        super(model);
        this.controller = controller;
        this.model = model;
    }

    @Override
    public void help() {
        model.addHelp(new Help()
                .add("help", "get help")
                .add("signUp {username} {password}", "registration")
                .add("signIn {username} {password}", "authentication")
        );
    }

    @Override
    public void signUp(String username, String password) {
        // TODO sign up logic
        controller.setState(State.INITIAL);
    }

    @Override
    public void signIn(String username, String password) {
        // TODO sign in logic
        controller.setState(State.INITIAL);
    }

    @Override
    public void error(String error) {
        model.addError(error);
    }
}
