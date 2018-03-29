package com.github.alexivchenko.chat.client.cli.mvc.controller.state;

import com.github.alexivchenko.chat.client.Message;
import com.github.alexivchenko.chat.client.User;
import com.github.alexivchenko.chat.client.cli.Matcher;
import com.github.alexivchenko.chat.client.cli.mvc.model.Model;

/**
 * @author Alex Ivchenko
 */
public class ChattingInChannelControllerState extends BaseControllerState {
    private final StatableController controller;
    private final Model model;

    public ChattingInChannelControllerState(StatableController controller, Model model) {
        super(model);
        this.model = model;
        this.controller = controller;
    }

    @Override
    public void users(Matcher<User> matcher) {

    }

    @Override
    public void send(Message message) {

    }

    @Override
    public void leave() {

    }
}
