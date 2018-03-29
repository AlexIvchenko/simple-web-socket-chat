package com.github.alexivchenko.chat.client.cli.mvc.controller.impl;

import com.github.alexivchenko.chat.client.Message;
import com.github.alexivchenko.chat.client.User;
import com.github.alexivchenko.chat.client.cli.Matcher;
import com.github.alexivchenko.chat.client.cli.mvc.controller.api.AuthController;
import com.github.alexivchenko.chat.client.cli.mvc.controller.api.ChannelMessagingController;
import com.github.alexivchenko.chat.client.cli.mvc.controller.api.DirectMessagingController;
import com.github.alexivchenko.chat.client.cli.mvc.controller.state.*;
import com.github.alexivchenko.chat.client.cli.mvc.model.Model;

/**
 * @author Alex Ivchenko
 */
public class ControllerImpl implements StatableController {
    private final ControllerState initial;
    private final ControllerState chattingWithUser;
    private final ControllerState chattingInChannel;
    private final ControllerState unauthorized;
    private final Model model;
    private ControllerState state;

    public ControllerImpl(Model model) {
        this.model = model;
        initial = new InitialControllerState(this);
        chattingWithUser = new ChattingWithUserControllerState(this, model);
        chattingInChannel = new ChattingInChannelControllerState(this, model);
        unauthorized = new UnauthorizedControllerState(this, model);
        state = unauthorized;
    }

    @Override
    public void setState(State state) {
        switch (state) {
            case INITIAL:
                this.state = initial;
                break;
            case CHATTING_WITH_USER:
                this.state = chattingWithUser;
                break;
            case CHATTING_IN_CHANNEL:
                this.state = chattingInChannel;
                break;
            case UNAUTHORIZED:
                this.state = unauthorized;
                break;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override
    public ControllerState getState() {
        return state;
    }

    @Override
    public AuthController auth() {
        return new AuthControllerImpl(this);
    }

    @Override
    public DirectMessagingController direct() {
        return new DirectMessagingControllerImpl(this);
    }

    @Override
    public ChannelMessagingController channel() {
        return new ChannelMessagingControllerImpl(this);
    }

    @Override
    public void help() {
        state.help();
    }

    @Override
    public void users(Matcher<User> matcher) {
        state.users(matcher);
    }

    @Override
    public void error(String error) {
        state.error(error);
    }

    @Override
    public void send(Message message) {
        state.send(message);
    }
}
