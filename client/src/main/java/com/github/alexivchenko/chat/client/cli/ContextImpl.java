package com.github.alexivchenko.chat.client.cli;

import com.github.alexivchenko.chat.client.Channel;
import com.github.alexivchenko.chat.client.User;
import com.github.alexivchenko.chat.client.cli.context.Context;
import lombok.Getter;
import lombok.Setter;

/**
 * @author Alex Ivchenko
 */
public class ContextImpl implements Context {
    @Getter
    @Setter
    private UserState userState;

    @Getter
    @Setter
    private User receiver;

    @Getter
    @Setter
    private Channel channel;
}
