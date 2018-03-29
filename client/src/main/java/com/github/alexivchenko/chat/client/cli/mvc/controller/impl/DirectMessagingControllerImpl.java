package com.github.alexivchenko.chat.client.cli.mvc.controller.impl;

import com.github.alexivchenko.chat.client.User;
import com.github.alexivchenko.chat.client.cli.mvc.controller.state.StatableController;
import com.github.alexivchenko.chat.client.cli.mvc.controller.api.DirectMessagingController;

/**
 * @author Alex Ivchenko
 */
public class DirectMessagingControllerImpl implements DirectMessagingController {
    private final StatableController controller;

    public DirectMessagingControllerImpl(StatableController controller) {
        this.controller = controller;
    }

    @Override
    public void startChatting(User user) {
        controller.getState().startChatting(user);
    }
}
