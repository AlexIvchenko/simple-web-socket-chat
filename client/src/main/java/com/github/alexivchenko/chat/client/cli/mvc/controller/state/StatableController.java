package com.github.alexivchenko.chat.client.cli.mvc.controller.state;

import com.github.alexivchenko.chat.client.cli.mvc.controller.api.Controller;

/**
 * @author Alex Ivchenko
 */
public interface StatableController extends Controller {
    void setState(State state);

    ControllerState getState();
}
